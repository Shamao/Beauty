package com.louise.gank.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lsd on 17/3/10.
 */

public class UIFlexIndicator extends LinearLayout implements ViewPager.OnPageChangeListener {

    private static final int S_D_SELECT_COLOR = Color.WHITE;
    private static final int S_D_UN_SELECT_COLOR = Color.GRAY;

    private static final int S_D_MIN_WIDTH_DP = 10;
    private static final int S_D_OFFSET_DP = 4;
    private static final int S_D_MARGIN = 6;


    private int mSelectColor;
    private int mUnSelectColor;
    private int mMinWidth;
    private int mOffset;
    private int margin;

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<UIDotView> mUIDotViews;

    private int mLastPos;

    public UIFlexIndicator(Context context) {
        this(context, null);
    }

    public UIFlexIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UIFlexIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initAttrs(attrs);
    }

    private void initAttrs(AttributeSet attrs) {
//        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.UIFlexIndicator);
//        mSelectColor = typedArray.getColor(R.styleable.UIFlexIndicator_gank_select_color, S_D_SELECT_COLOR);
//        mUnSelectColor = typedArray.getColor(R.styleable.UIFlexIndicator_gank_un_select_color, S_D_UN_SELECT_COLOR);
//
//        mMinWidth =
//                typedArray.getDimensionPixelSize(R.styleable.UIFlexIndicator_gank_min_width, dp2px(S_D_MIN_WIDTH_DP));
//        mOffset =
//                typedArray.getDimensionPixelSize(R.styleable.UIFlexIndicator_gank_offset, dp2px(S_D_OFFSET_DP));
//        margin = typedArray.getDimensionPixelSize(R.styleable.UIFlexIndicator_gank_margin, dp2px(S_D_MARGIN));
//        typedArray.recycle();

        setGravity(Gravity.CENTER);
        setOrientation(LinearLayout.HORIZONTAL);
        mUIDotViews = new ArrayList<>();

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (mViewPager.getChildCount() == 1) {
            return;
        }

        if (positionOffset > 0) {
            UIDotView firstChild = mUIDotViews.get(position);
            int firstOffset = (int) (firstChild.getMeasuredWidth() + (1 - positionOffset) * mOffset);
            firstChild.withWidth(firstOffset).build();

            if (mUIDotViews.size() > 1) {
                UIDotView secondChild = mUIDotViews.get(position + 1);
                int secondOffset = (int) (firstChild.getMeasuredWidth() + positionOffset * mOffset);
                secondChild.withWidth((secondOffset)).build();
            }
        }

        if (mSimpleOnPageChangeListener != null) {
            mSimpleOnPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        mUIDotViews.get(mLastPos).withWidth(mUnSelectColor).build();
        mUIDotViews.get(position).withWidth(mSelectColor).build();
        mLastPos = position;

        if (mSimpleOnPageChangeListener != null) {
            mSimpleOnPageChangeListener.onPageSelected(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (mSimpleOnPageChangeListener != null) {
            mSimpleOnPageChangeListener.onPageScrollStateChanged(state);
        }
    }


    public void setupWithViewPager(ViewPager viewPager) {
        //        if (mViewPager == viewPager) {
        //            return;
        //        }
        if (mViewPager != null) {
            mViewPager.clearOnPageChangeListeners();
        }

        PagerAdapter pagerAdapter = viewPager.getAdapter();
        if (pagerAdapter == null) {
            throw new NullPointerException("viewPager's adapter is null");
        }
        this.mViewPager = viewPager;
        notifyDataSetChanged();
        mViewPager.addOnPageChangeListener(this);
    }

    public void notifyDataSetChanged() {
        removeAllViews();
        mUIDotViews.clear();
        PagerAdapter pagerAdapter = mViewPager.getAdapter();
        int pageCount = pagerAdapter.getCount();
        for (int i = 0; i < pageCount; i++) {
            UIDotView child = new UIDotView(getContext());
            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                               ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i < pageCount - 1) {
                lp.rightMargin = margin;
            }
            child.setLayoutParams(lp);
            child.withColor(mUnSelectColor).withWidth(mMinWidth).build();
            mUIDotViews.add(child);
            addView(child);
        }
        int currentItem = mViewPager.getCurrentItem();
        if (currentItem < mUIDotViews.size()) {
            UIDotView child = mUIDotViews.get(currentItem);
            child.withWidth(child.getMeasuredWidth() + mOffset).withColor(mSelectColor).build();
        }
    }

    private int dp2px(int dp) {
        return (int) (getContext().getResources().getDisplayMetrics().density * dp + 0.5);
    }

    public void setSimpleOnPageChangeListener(SimpleOnPageChangeListener simpleOnPageChangeListener) {
        mSimpleOnPageChangeListener = simpleOnPageChangeListener;
    }

    private SimpleOnPageChangeListener mSimpleOnPageChangeListener;

    public static class SimpleOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // This space for rent
        }

        @Override
        public void onPageSelected(int position) {
            // This space for rent
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            // This space for rent
        }
    }
}
