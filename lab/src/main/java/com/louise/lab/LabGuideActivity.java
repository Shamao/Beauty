package com.louise.lab;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.base.manager.RouterManager;
import com.louise.lab.adapter.LabGuideAdapter;
import com.louise.lab.view.ParallaxTransformer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lsd
 * @date 2018/2/8.
 */
@Route(path = "/lab/guide")
public class LabGuideActivity extends BaseActivity {
    @BindView(R2.id.lab_pager)
    ViewPager mViewPager;
    private LabGuideAdapter mAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_guide;
    }

    @Override
    public View getLayoutView() {
        return null;
    }

    @Override
    public void initData() {
        mAdapter = new LabGuideAdapter();
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPageTransformer(false, new ParallaxTransformer());
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 3) {
                    RouterManager.getInstance().navigation(LabGuideActivity.this, "/lab/main");
                }
            }
        });
    }
}
