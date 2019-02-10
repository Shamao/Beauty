package com.louise.lab;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.lab.adapter.RecyclerAdapter;
import com.louise.lab.bean.MColumnBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lsd
 * @date 2018/11/15.
 */
@Route(path = "/lab/recycler")
public class LabRecyclerViewActivity extends BaseActivity {

    RecyclerView mRecyclerView;
    RecyclerAdapter mAdapter;
    LinearLayoutManager mLinearLayoutManager;
    private List<MColumnBean> mData;

    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_recycler;
    }

    @Override
    public void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mData.add(new MColumnBean("标题" + i));
        }
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mRecyclerView = findViewById(R.id.lab_recycler);
        mAdapter = new RecyclerAdapter(mData);
        mRecyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


}
