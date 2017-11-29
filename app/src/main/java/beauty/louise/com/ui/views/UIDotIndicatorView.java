package beauty.louise.com.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.ui.views.Common.IndicatorDotView;
import buykee.com.common.utils.Logger;

/**
 * Created by lsd on 17/3/10.
 */

public class UIDotIndicatorView extends LinearLayout implements ViewPager.OnPageChangeListener {

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
    private List<IndicatorDotView> mIndicatorDotViews;

    private int mLastPos;

    public UIDotIndicatorView(Context context) {
        this(context, null);
    }

    public UIDotIndicatorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UIDotIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initAttrs(attrs);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.UIDotIndicatorView);
        mSelectColor = typedArray.getColor(R.styleable.UIDotIndicatorView_select_color, S_D_SELECT_COLOR);
        mUnSelectColor = typedArray.getColor(R.styleable.UIDotIndicatorView_un_select_color, S_D_UN_SELECT_COLOR);

        mMinWidth =
                typedArray.getDimensionPixelSize(R.styleable.UIDotIndicatorView_min_width, dp2px(S_D_MIN_WIDTH_DP));
        mOffset =
                typedArray.getDimensionPixelSize(R.styleable.UIDotIndicatorView_offset, dp2px(S_D_OFFSET_DP));
        margin = typedArray.getDimensionPixelSize(R.styleable.UIDotIndicatorView_margin, dp2px(S_D_MARGIN));
        typedArray.recycle();

        setGravity(Gravity.CENTER);
        setOrientation(LinearLayout.HORIZONTAL);
        mIndicatorDotViews = new ArrayList<>();

        Logger.d("attrs", mSelectColor, mUnSelectColor, mMinWidth, mOffset);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset > 0) {
            IndicatorDotView firstChild = mIndicatorDotViews.get(position);
            IndicatorDotView secondChild = mIndicatorDotViews.get(position + 1);
            int firstOffset = (int) (firstChild.getDefaultSize() + (1 - positionOffset) * mOffset);
            firstChild.setResultWidth(firstOffset);
            int secondOffset = (int) (firstChild.getDefaultSize() + positionOffset * mOffset);
            secondChild.setResultWidth((secondOffset));
        }

        if (mSimpleOnPageChangeListener != null) {
            mSimpleOnPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        mIndicatorDotViews.get(mLastPos).setColor(mUnSelectColor);
        mIndicatorDotViews.get(position).setColor(mSelectColor);
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
        if (mViewPager != null) {
            return;
        }
        this.mViewPager = viewPager;
        PagerAdapter pagerAdapter = viewPager.getAdapter();
        if (pagerAdapter == null) {
            throw new NullPointerException("viewPager's adapter is null");
        }

        int pageCount = pagerAdapter.getCount();
        for (int i = 0; i < pageCount; i++) {
            IndicatorDotView child = new IndicatorDotView(getContext());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                                         ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i < pageCount - 1) {
                lp.rightMargin = margin;
            }
            child.setLayoutParams(lp);
            child.config(mUnSelectColor, mMinWidth);
            mIndicatorDotViews.add(child);
            addView(child);
        }
        mLastPos = mViewPager.getCurrentItem();
        IndicatorDotView child = mIndicatorDotViews.get(mLastPos);
        child.setResultWidth(child.getDefaultSize() + mOffset);
        child.setColor(mSelectColor);
        mViewPager.addOnPageChangeListener(this);
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
