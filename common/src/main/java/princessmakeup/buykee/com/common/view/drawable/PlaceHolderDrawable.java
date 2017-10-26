package princessmakeup.buykee.com.common.view.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import princessmakeup.buykee.com.common.utils.Logger;

/**
 * Created by lsd on 2017/10/26.
 */

public class PlaceHolderDrawable extends Drawable {
    private static final String mTag = PlaceHolderDrawable.class.getSimpleName();
    private Paint mPaint;
    private Bitmap mBitmap;
    private Matrix matrix;
    private BitmapShader shader;
    private float mRatioV;

    private int mIntrinsicWidth;
    private int mIntrinsicHeight;


    public PlaceHolderDrawable(Bitmap bitmap) {
        this(bitmap, -1);
    }

    public PlaceHolderDrawable(Bitmap bitmap, float ratioV) {
        this.mBitmap = bitmap;
        mRatioV = ratioV;
        init();

    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        matrix = new Matrix();
        mIntrinsicWidth = mBitmap.getWidth();
        mIntrinsicHeight = mRatioV < 0 ? mBitmap.getHeight() : Math.round(mBitmap.getWidth() * mRatioV);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        Logger.d(mTag, "onBoundsChange", mIntrinsicWidth, mIntrinsicHeight,
                 bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    @Override
    public void setBounds(@NonNull Rect bounds) {
        super.setBounds(bounds);
        mIntrinsicWidth = bounds.right - bounds.left;
        mIntrinsicHeight = bounds.bottom - bounds.top;
        Logger.d(mTag, "setBounds", bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        mIntrinsicWidth = right - left;
        mIntrinsicHeight = bottom - top;
        Logger.d(mTag, "setBounds", left, top, right, bottom);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        //获取imageView的矩形边框
        Rect rect = getBounds();
        Logger.d(mTag, "draw", rect.width(), rect.height(), rect.left, rect.top, rect.right, rect.bottom);
        float scaleWidth = rect.width() * 1.0f / mBitmap.getWidth();
        float scaleHeight = rect.height() * 1.0f / mBitmap.getHeight();

        float scale = scaleHeight > scaleWidth ? scaleWidth : scaleHeight;
        Bitmap resultBitmap =
                Bitmap.createScaledBitmap(mBitmap,
                                          (int) (mBitmap.getWidth() * scale),
                                          (int) (mBitmap.getHeight() * scale),
                                          true);
        //        float scale = Math.max(
        //                rect.width() * 1.0f / mBitmap.getWidth(),
        //                rect.height() * 1.0f / mBitmap.getHeight());
        //        matrix.setScale(scale, scale);
        //        shader.setLocalMatrix(matrix);
        shader = new BitmapShader(resultBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        //        canvas.drawRect(rect, mPaint);
        //        canvas.translate((rect.width() - mBitmap.getWidth()) / 2, (rect.height() - mBitmap.getHeight()) / 2);
        int radiusX = resultBitmap.getWidth() / 2;
        int radiusY = resultBitmap.getHeight() / 2;
        //        canvas.drawRect(
        //                rect.width() / 2 - radiusX,
        //                rect.height() / 2 - radiusY,
        //                rect.width() / 2 + radiusX,
        //                rect.height() / 2 + radiusY,
        //                mPaint);
        canvas.drawRect(0, 0, rect.width(), rect.height(), mPaint);
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
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

    //下面两个方法主要用于在view使用wrapContent的时候使用的
    @Override
    public int getIntrinsicHeight() {
        return mIntrinsicHeight;
    }

    @Override
    public int getIntrinsicWidth() {
        return mIntrinsicWidth;
    }
}
