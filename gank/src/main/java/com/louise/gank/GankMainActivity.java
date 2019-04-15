package com.louise.gank;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.base.utils.ALogger;
import com.louise.base.utils.DisplayUtils;
import com.louise.base.view.itemDecoration.CommonLinearItemDecoration;
import com.louise.gank.bean.MHabit;
import com.louise.gank.view.provider.HabitProvider;

import java.util.ArrayList;
import java.util.List;

import cc.hiy.baseui.titlebar.UITitleBar;
import cc.hiy.baseui.titlebar.provider.DividerViewProvider;
import cc.hiy.baseui.titlebar.provider.TitleViewProvider;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author ssss
 */
@Route(path = "/gank/main")
public class GankMainActivity extends BaseActivity {

    private UITitleBar mTitleBar;

    private RecyclerView mHabitRv;
    private MultiTypeAdapter mAdapter;
    private List<Object> mDatas;

    @Override
    public int getLayoutId() {
        return R.layout.gank_ac_main;
    }

    @Override
    public void initData() {
        mDatas = new ArrayList<>();
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initTitleView();


        mHabitRv = findViewById(R.id.habit_rv);
        mHabitRv.setHasFixedSize(true);
        mHabitRv.setLayoutManager(new LinearLayoutManager(this));
        mHabitRv.addItemDecoration(new CommonLinearItemDecoration(DisplayUtils.dip2px(this, 10)));

        mAdapter = new MultiTypeAdapter(mDatas);
        mAdapter.register(MHabit.class, new HabitProvider());
        mHabitRv.setAdapter(mAdapter);
    }

    private void initTitleView() {
        mTitleBar = findViewById(R.id.title_bar);
        TitleViewProvider provider = new TitleViewProvider(this);
        provider.setText("习惯广场");
        mTitleBar.updateCenterViewProvider(provider);

        DividerViewProvider dividerViewProvider = new DividerViewProvider(this);
        mTitleBar.updateBottomViewProvider(dividerViewProvider);
    }

    @Override
    public void initListener() {
        super.initListener();

        mHabitRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }


            /**
             * @return todo
             */
            public int getScollYDistance() {
                LinearLayoutManager layoutManager = (LinearLayoutManager) mHabitRv.getLayoutManager();
                int position = layoutManager.findFirstVisibleItemPosition();
                View firstVisiableChildView = layoutManager.findViewByPosition(position);
                int itemHeight = firstVisiableChildView.getHeight();
                return (position) * itemHeight - firstVisiableChildView.getTop();
            }


            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                ALogger.d(mTag, "onScroll = " + getScollYDistance());
                dy = getScollYDistance();
                if (dy < 500) {
                    mTitleBar.setViewAlpha(dy * 1.0f / 500);
                } else {
                    mTitleBar.setViewAlpha(1f);
                }
            }
        });
    }

    @Override
    public void loadData() {
        super.loadData();
        mHabitRv.postDelayed(new Runnable() {
            @Override
            public void run() {
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mDatas.add(new MHabit());
                mAdapter.notifyDataSetChanged();
            }
        }, 0);


    }
}
