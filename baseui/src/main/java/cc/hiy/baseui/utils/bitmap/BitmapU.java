package cc.hiy.baseui.utils.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/**
 * Bitmap 工具类
 *
 * @author lsd
 * @date 2019/5/8.
 */
public class BitmapU {

    public static Bitmap transformBitmap(Bitmap origin) {
        return transformBitmap(origin, new DefaultShapeRender());
    }

    public static Bitmap transformBitmap(Bitmap origin, IShapeRender shapeRender) {
        Bitmap target = shapeRender.createBitmap(origin);
        Canvas canvas = new Canvas(target);
        shapeRender.drawDst(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(origin, 0, 0, paint);
        return target;
    }
}
