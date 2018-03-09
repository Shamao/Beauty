package com.louise.gank;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.base.bean.gank.MGankWelfareBean;
import com.louise.base.view.itemDecoration.CommonLinearItemDecoration;
import com.louise.gank.bean.MUserBean;
import com.louise.gank.databinding.GankAcMainBinding;
import com.louise.gank.view.DiagonalDrawable;
import com.louise.gank.view.provider.WelfareProvider;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author ssss
 */
@Route(path = "/gank/main")
public class GankMainActivity extends BaseActivity {

    private GankAcMainBinding mBinding;

    private RecyclerView.ItemDecoration mItemDecoration;
    private MultiTypeAdapter mAdapter;
    private List<MGankWelfareBean> mData;

    @Override
    public void initContentLayout() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.gank_ac_main);
    }

    @Override
    public void initData() {
        mData = new ArrayList<>();
        mAdapter = new MultiTypeAdapter(mData);
        mAdapter.register(MGankWelfareBean.class, new WelfareProvider());

        mItemDecoration = new CommonLinearItemDecoration((int) (this.getResources().getDisplayMetrics().density * 10),
                                                         LinearLayoutManager.VERTICAL);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mBinding.recycler.setHasFixedSize(true);
        mBinding.recycler.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recycler.addItemDecoration(mItemDecoration);
        mBinding.recycler.setAdapter(mAdapter);

        mBinding.setUser(new MUserBean("看妹子", "看妹子"));
        mBinding.setActivity(this);
        mBinding.setHandlers(new MyHandlers());

        DiagonalDrawable.Builder builder = new DiagonalDrawable.Builder()
                .setStartColor(Color.parseColor("#E52878"))
                .setEndColor(Color.parseColor("#EE2A7B"))
                .setReverseLayout(true);

        DiagonalDrawable drawable = builder.build();
        mBinding.barView.setBackground(drawable);
    }


    public void onUserClick(View view, MUserBean user) {
        Toast.makeText(this, view.getId() + user.getName() + user.getDesc(), Toast.LENGTH_SHORT).show();
    }

    public class MyHandlers {
        public void onClick(View view) {
            GankApi.getInstance().getGankWelfare(20, 1, new GankApi.Callback<List<MGankWelfareBean>>() {
                @Override
                public void onCallback(List<MGankWelfareBean> data) {
                    mData.addAll(data);
                    mAdapter.notifyDataSetChanged();
                }
            });
        }
    }

}
