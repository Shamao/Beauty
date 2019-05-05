package com.louise.lab;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.base.utils.DisplayUtils;
import cc.hiy.baseui.itemDecoration.CommonLinearItemDecoration;
import com.louise.lab.adapter.provider.ColumnProvider;
import com.louise.lab.adapter.provider.SimpleColumnProvider;
import com.louise.lab.bean.MColumnBean;
import com.louise.lab.bean.MMenuBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author ssss
 */
@Route(path = "/lab/main")
public class LabMainActivity extends BaseActivity {

    @BindView(R2.id.lab_recycler)
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MultiTypeAdapter mAdapter;
    private List<Object> mData;

    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_main;
    }

    @Override
    public View getLayoutView() {
        return null;
    }

    @Override
    public void initData() {
        mData = new ArrayList<>();
        mData.add(new MColumnBean("引导页"));
        mData.add(new MMenuBean("大本营", "/main/main"));
        mData.add(new MMenuBean("测试MVP生命周期", "/lab/test"));
        mData.add(new MMenuBean("过度绘制", "/lab/view"));
        mData.add(new MMenuBean("RecyclerView", "/lab/recycler"));
        mAdapter = new MultiTypeAdapter(mData);
        mAdapter.register(MColumnBean.class, new ColumnProvider());
        mAdapter.register(MMenuBean.class, new SimpleColumnProvider());
    }


    @Override
    public void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        int padding = DisplayUtils.dip2px(this, 10);
        CommonLinearItemDecoration itemDecoration =
                new CommonLinearItemDecoration(padding, LinearLayoutManager.VERTICAL)
                        .withEdge(padding, padding);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
