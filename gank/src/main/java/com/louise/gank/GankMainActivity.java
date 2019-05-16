package com.louise.gank;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.base.utils.ALogger;
import com.louise.gank.bean.MHabit;
import com.louise.gank.view.adapter.MainAdAdapter;
import com.louise.gank.view.provider.HabitProvider;

import java.util.ArrayList;
import java.util.List;

import cc.hiy.baseui.flexbox.UIFlexBoxView;
import cc.hiy.baseui.itemDecoration.CommonLinearItemDecoration;
import cc.hiy.baseui.titlebar.UITitleBar;
import cc.hiy.baseui.titlebar.provider.ImageViewProvider;
import cc.hiy.baseui.titlebar.provider.TextDrawViewProvider;
import cc.hiy.baseui.titlebar.provider.TitleViewProvider;
import cc.hiy.baseui.utils.DisplayUtils;
import cc.hiy.baseui.utils.bitmap.BitmapU;
import cc.hiy.baseui.utils.bitmap.PathShapeRender;
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
    private UIFlexBoxView mAdFlex;

    private ImageView mIntroIv;

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

        mAdFlex = findViewById(R.id.ad_flex);
        mAdFlex.setVisibility(View.VISIBLE);
        mAdFlex.setAdapter(new MainAdAdapter());


        mIntroIv = findViewById(R.id.intro_iv);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_blue);
        mIntroIv.setImageBitmap(BitmapU.transformBitmap(bitmap, new PathShapeRender()));

    }

    private void initTitleView() {
        mTitleBar = findViewById(R.id.title_bar);
        TitleViewProvider provider = new TitleViewProvider(this);
        provider.setText("习惯广场");
        mTitleBar.updateCenterViewProvider(provider);

        TextDrawViewProvider leftProvider = new TextDrawViewProvider(this);
        Drawable drawable = getResources().getDrawable(R.drawable.ic_close);
        drawable.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        leftProvider.setDraw(drawable, null);
        leftProvider.setText("sss");
        mTitleBar.updateLeftViewProvider(leftProvider);

        ImageViewProvider imageVIewProvider = new ImageViewProvider(this);
        mTitleBar.updateRightViewProvider(imageVIewProvider);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_blue, options);
        imageVIewProvider.setImageBitmap(BitmapU.transformBitmap(bitmap, new PathShapeRender()));

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
