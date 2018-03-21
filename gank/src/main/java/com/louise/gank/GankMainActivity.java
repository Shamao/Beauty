package com.louise.gank;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.base.bean.gank.MGankWelfareBean;
import com.louise.base.utils.DisplayUtils;
import com.louise.base.utils.Logger;
import com.louise.base.view.itemDecoration.CommonLinearItemDecoration;
import com.louise.gank.bean.MUserBean;
import com.louise.gank.databinding.GankAcMainBinding;
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
    private RecyclerView.LayoutManager mLayoutManager;
    private MultiTypeAdapter mAdapter;
    private List<MGankWelfareBean> mData;

    private ValueAnimator mDotAnimator;

    @Override
    public void initContentLayout() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.gank_ac_main);
    }

    @Override
    public void initData() {
        mData = new ArrayList<>();
        mAdapter = new MultiTypeAdapter(mData);
        mAdapter.register(MGankWelfareBean.class, new WelfareProvider());

        int padding = DisplayUtils.dip2px(this, 10);
        mItemDecoration = new CommonLinearItemDecoration(padding, LinearLayoutManager.VERTICAL);
        mLayoutManager = new LinearLayoutManager(this);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mBinding.setUser(new MUserBean("sdfsdf", "sfsdfa"));
        mBinding.recycler.setHasFixedSize(true);
        mBinding.recycler.setLayoutManager(mLayoutManager);
        mBinding.recycler.addItemDecoration(mItemDecoration);
        mBinding.recycler.setAdapter(mAdapter);

        initAnim();

        mBinding.swipe.setColorSchemeColors(Color.RED);
        mBinding.swipe.setDistanceToTriggerSync(DisplayUtils.dip2px(this, 20));

    }

    private void initAnim() {
        mDotAnimator = ValueAnimator.ofFloat(1.0f, 10.0f);
        mDotAnimator.setDuration(2000);
        mDotAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mDotAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                int initWidth = mBinding.dotView.getInitWidth();
                mBinding.dotView.withWidth((int) (initWidth * value)).build();

            }
        });

        mBinding.dotView.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 500);

        mDotAnimator.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                Logger.d("onAnimationStart");
                getGankWelfare();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Logger.d("onAnimationEnd");
                mBinding.loadingLayout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mDotAnimator.start();
    }

    private void getGankWelfare() {
        GankApi.getInstance().getGankWelfare(20, 1, new GankApi.Callback<List<MGankWelfareBean>>() {
            @Override
            public void onCallback(List<MGankWelfareBean> data) {
                mData.clear();
                mData.addAll(data);
                mAdapter.notifyDataSetChanged();
                cancelRefresh();
            }
        });
    }

    @Override
    public void initListener() {
        super.initListener();
        mBinding.swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getGankWelfare();
            }
        });
    }

    private void cancelRefresh() {
        mBinding.swipe.postDelayed(new Runnable() {
            @Override
            public void run() {
                mBinding.swipe.setRefreshing(false);
            }
        }, 300);
    }

}
