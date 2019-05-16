package cc.hiy.baseui.utils.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * @author lsd
 * @date 2019/5/14.
 */
public class DefaultShapeRender implements IShapeRender {

    @Override
    public Bitmap createBitmap(Bitmap origin) {
        return Bitmap.createBitmap(origin.getWidth(), origin.getHeight(), Bitmap.Config.ARGB_8888);
    }

    @Override
    public void drawDst(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Rect rect = new Rect(0, 0, width, height);
        canvas.drawRect(rect, paint);
    }

    //    @Override
    //    public void drawSrc(Canvas canvas, Bitmap origin) {
    //        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    //        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    //        canvas.drawBitmap(origin, 0, 0, paint);
    //    }
}