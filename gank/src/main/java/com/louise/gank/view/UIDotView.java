package com.louise.gank.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author lsd
 * @date 2018/3/5.
 */

public class UIDotView extends View {
    private static final int S_D_SIZE = 10;
    private static final int S_D_COLOR = Color.GREEN;

    private int mColor;

    private int mExceptWidth;
    private int mExceptHeight;

    private Paint mPaint;
    private RectF rectF;

    public UIDotView(Context context) {
        super(context);
        init();
    }

    public UIDotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UIDotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);

        mExceptWidth = dp2px(S_D_SIZE);
        mExceptHeight = dp2px(S_D_SIZE);

        rectF = new RectF(0, 0, mExceptWidth, mExceptHeight);
        mColor = S_D_COLOR;
    }

    public UIDotView withColor(@ColorInt int color) {
        this.mColor = color;
        return this;
    }

    public UIDotView withSize(int size) {
        withWidth(size);
        withHeight(size);
        return this;
    }

    public UIDotView withWidth(int width) {
        this.mExceptWidth = width;
        return this;
    }

    public UIDotView withHeight(int height) {
        this.mExceptHeight = height;
        return this;
    }

    public void build() {
        requestLayout();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mResultWidth = resolveSize(mExceptWidth, widthMeasureSpec);
        int mResultHeight = resolveSize(mExceptHeight, heightMeasureSpec);
        setMeasuredDimension(mResultWidth, mResultHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mColor);
        rectF.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int radius = (int) (Math.min(rectF.width(), rectF.height())) / 2;
        canvas.drawRoundRect(rectF, radius, radius, mPaint);
    }

    // ---- ---- ---- ---- ---- ---- ---- ---- ---- ----
    public int getColor() {
        return mColor;
    }

    private int dp2px(int dp) {
        return (int) (getContext().getResources().getDisplayMetrics().density * dp + 0.5);
    }

}
