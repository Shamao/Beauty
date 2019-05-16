package cc.hiy.baseui.utils.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * @author lsd
 * @date 2019/5/14.
 */
public class RoundShapeRender implements IShapeRender {

    private float mRadius;

    public RoundShapeRender() {
    }

    public RoundShapeRender(float radius) {
        this.mRadius = radius;
    }

    @Override
    public Bitmap createBitmap(Bitmap origin) {
        return Bitmap.createBitmap(origin.getWidth(), origin.getHeight(), Bitmap.Config.ARGB_8888);
    }

    @Override
    public void drawDst(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        RectF rect = new RectF(0, 0, width, height);
        canvas.drawRoundRect(rect, this.mRadius, this.mRadius, paint);
    }

//    @Override
//    public void drawSrc(Canvas canvas, Bitmap origin) {
//        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        canvas.drawBitmap(origin, 0, 0, paint);
//    }
}