package com.louise.gank.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author lsd
 * @date 2018/3/12.
 */

public class AdaptiveDrawable extends Drawable {
    public static final int S_NO_CORNOR = 0;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 1 << 1;
    public static final int CORNER_BOTTOM_RIGHT = 1 << 2;
    public static final int CORNER_BOTTOM_LEFT = 1 << 3;
    public static final int CORNER_ALL = CORNER_TOP_LEFT | CORNER_TOP_RIGHT | CORNER_BOTTOM_LEFT | CORNER_BOTTOM_RIGHT;


    private int mRadius;
    private int mCorners;
    private int mBgColor;

    private Paint mPaint;

    private RectF mBitmapRect;
    private RectF mRectF;

    private BitmapShader bitmapShader;

    public AdaptiveDrawable(Bitmap bitmap) {
        this(bitmap, 0, S_NO_CORNOR, Color.TRANSPARENT);
    }

    public AdaptiveDrawable(Bitmap bitmap, int radius, int corners, int bgColor) {
        mCorners = corners;
        mRadius = radius;
        mBgColor = bgColor;

        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mBitmapRect = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setShader(bitmapShader);
        mRectF = new RectF();
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        float bitmapRatio = mBitmapRect.height() * 1.0f / mBitmapRect.width();
        float boundRatio = bounds.height() * 1.0f / bounds.width();

        float left;
        float top;
        float right;
        float bottom;

        if (bitmapRatio == boundRatio) {
            left = bounds.left;
            top = bounds.top;
            right = bounds.right;
            bottom = bounds.bottom;
        } else if (boundRatio > bitmapRatio) {
            left = bounds.left;
            top = (bounds.height() - bounds.width() * bitmapRatio) / 2;
            right = bounds.right;
            bottom = bounds.height() - (bounds.height() - bounds.width() * bitmapRatio) / 2;
        } else {
            left = (bounds.width() - bounds.height() / bitmapRatio) / 2;
            top = bounds.top;
            bottom = bounds.bottom;
            right = bounds.width() - (bounds.width() - bounds.height() / bitmapRatio) / 2;
        }

        mRectF = new RectF(left, top, right, bottom);

        Matrix shaderMatrix = new Matrix();
        shaderMatrix.setRectToRect(mBitmapRect, mRectF, Matrix.ScaleToFit.FILL);
        bitmapShader.setLocalMatrix(shaderMatrix);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Paint cornerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        cornerPaint.setStyle(Paint.Style.FILL);
        cornerPaint.setColor(mBgColor);
        RectF bgRectF = transformRectF(getBounds());
        canvas.drawRoundRect(bgRectF, mRadius, mRadius, cornerPaint);

        canvas.drawRoundRect(mRectF, 0, 0, mPaint);
        int notRoundedCorners = mCorners ^ CORNER_ALL;

        if ((notRoundedCorners & CORNER_TOP_LEFT) != 0) {
            canvas.drawRect(0, 0, mRadius, mRadius, cornerPaint);
        }

        if ((notRoundedCorners & CORNER_TOP_RIGHT) != 0) {
            canvas.drawRect(bgRectF.right - mRadius, 0, bgRectF.right, mRadius, cornerPaint);
        }
        if ((notRoundedCorners & CORNER_BOTTOM_LEFT) != 0) {
            canvas.drawRect(0, bgRectF.bottom - mRadius, mRadius, bgRectF.bottom, cornerPaint);
        }
        if ((notRoundedCorners & CORNER_BOTTOM_RIGHT) != 0) {
            canvas.drawRect(bgRectF.right - mRadius, bgRectF.bottom - mRadius, bgRectF.right, bgRectF.bottom,
                            cornerPaint);
        }
    }

    private RectF transformRectF(Rect rect) {
        return new RectF(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }
}
