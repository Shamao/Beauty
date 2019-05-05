package cc.hiy.baseui.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 根据容器自适应适配 todo lsd
 *
 * @author liusaideng
 * @date 2018/9/19 下午4:18
 */
public class AdaptiveDrawable extends Drawable {
    private Bitmap mBitmap;
    private int mIntrinsicHeight;
    private int mIntrinsicWidth;
    private Paint mPaint;
    private float mRatioV;

    public AdaptiveDrawable(Bitmap paramBitmap) {
        this(paramBitmap, -1.0F);
    }

    public AdaptiveDrawable(Bitmap paramBitmap, float paramFloat) {
        this.mBitmap = paramBitmap;
        this.mRatioV = paramFloat;
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mIntrinsicWidth = this.mBitmap.getWidth();
        if (this.mRatioV < 0.0F) {
        }
        for (int i = this.mBitmap.getHeight(); ; i = Math.round(this.mBitmap.getWidth() * this.mRatioV)) {
            this.mIntrinsicHeight = i;
            return;
        }
    }

    public void draw(@NonNull Canvas paramCanvas) {
        paramCanvas.drawColor(Color.parseColor("#F5F5F5"));
        Rect localRect = getBounds();
        float f1 = localRect.width() * 1.0F / this.mBitmap.getWidth();
        float f2 = localRect.height() * 1.0F / this.mBitmap.getHeight();
        if (f2 > f1) {
        }
        for (; ; ) {
            float f3 = this.mBitmap.getWidth();
            f2 = this.mBitmap.getHeight();
            int i = (int) (f3 * f1 / 2.0F);
            int j = (int) (f2 * f1 / 2.0F);
            paramCanvas.drawBitmap(this.mBitmap, null,
                    new Rect(localRect.width() / 2 - i, localRect.height() / 2 - j, localRect.width() / 2 + i,
                            localRect.height() / 2 + j), null);
            return;
        }
    }

    public int getIntrinsicHeight() {
        return this.mIntrinsicHeight;
    }

    public int getIntrinsicWidth() {
        return this.mIntrinsicWidth;
    }

    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    protected void onBoundsChange(Rect paramRect) {
        super.onBoundsChange(paramRect);
    }

    public void setAlpha(@IntRange(from = 0L, to = 255L) int paramInt) {
        this.mPaint.setAlpha(paramInt);
    }

    public void setColorFilter(@Nullable ColorFilter paramColorFilter) {
        this.mPaint.setColorFilter(paramColorFilter);
    }
}
