package com.louise.gank.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.louise.base.utils.Logger;
import com.louise.base.utils.constance.ConstTag;

/**
 * @author lsd
 * @date 2018/3/9.
 */

public class DiagonalDrawable extends Drawable {

    private Paint mPaint;

    private PointF mStartPoint;
    private PointF mEndPoint;

    private Path mStartPath;
    private int mStartColor;

    private Path mEndPath;
    private int mEndColor;

    private boolean isReverseLayout;


    public DiagonalDrawable(int startColor, int endColor, boolean isReverseLayout) {
        mStartColor = startColor;
        mEndColor = endColor;
        this.isReverseLayout = isReverseLayout;

        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mStartPath = new Path();
        mEndPath = new Path();

    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        Logger.d(ConstTag.S_DRAWABLE, "onBoundsChange");
        invalidatePath(isReverseLayout, bounds);
    }

    private void invalidatePath(boolean isReverseLayout, Rect bounds) {
        float right = bounds.right * 1.0f;
        float bottom = bounds.bottom * 1.0f;

        mStartPoint = new PointF();
        mEndPoint = new PointF(right, bottom);

        mStartPath = new Path();
        mEndPath = new Path();

        mStartPoint = new PointF(right, 0f);
        mEndPoint = new PointF(0, bottom);

        if (isReverseLayout) {
            mStartPoint.x = right;
            mStartPoint.y = 0f;
            mEndPoint.x = 0f;
            mEndPoint.y = bottom;

            mStartPath.moveTo(right, 0f);
            mStartPath.lineTo(right, bottom);
            mStartPath.lineTo(0f, bottom);
            mStartPath.lineTo(right, 0f);

            mEndPath.moveTo(right, 0f);
            mEndPath.lineTo(0f, 0f);
            mEndPath.lineTo(0f, bottom);
            mEndPath.lineTo(right, 0f);
        } else {
            mStartPoint.x = 0f;
            mStartPoint.y = 0f;
            mEndPoint.x = right;
            mEndPoint.y = bottom;

            mStartPath.moveTo(0f, 0f);
            mStartPath.lineTo(0f, bottom);
            mStartPath.lineTo(right, bottom);
            mStartPath.lineTo(0f, 0f);

            mEndPath.moveTo(0f, 0f);
            mEndPath.lineTo(right, 0f);
            mEndPath.lineTo(right, bottom);
            mEndPath.lineTo(0, 0);
        }

        mStartPath.close();
        mEndPath.close();
    }


    @Override
    public void draw(@NonNull Canvas canvas) {
        mPaint.setColor(mStartColor);
        canvas.drawPath(mStartPath, mPaint);

        mPaint.setColor(mEndColor);
        canvas.drawPath(mEndPath, mPaint);

        if (isReverseLayout) {
            canvas.drawLine(mStartPoint.x, mStartPoint.y, mEndPoint.x, mEndPoint.y, mPaint);
        }
    }

    @Override
    public void setAlpha(int alpha) {
        setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    public static class Builder {
        private int mStartColor = Color.TRANSPARENT;
        private int mEndColor = Color.TRANSPARENT;
        private boolean isReverseLayout = false;

        public Builder setStartColor(int startColor) {
            mStartColor = startColor;
            return this;
        }


        public Builder setEndColor(int endColor) {
            mEndColor = endColor;
            return this;
        }


        public Builder setReverseLayout(boolean reverseLayout) {
            isReverseLayout = reverseLayout;
            return this;
        }

        public DiagonalDrawable build() {
            return new DiagonalDrawable(mStartColor, mEndColor, isReverseLayout);
        }
    }
}
