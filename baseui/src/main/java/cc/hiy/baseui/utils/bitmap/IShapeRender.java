package cc.hiy.baseui.utils.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * @author lsd
 * @date 2019/5/14.
 */
public interface IShapeRender {

    Bitmap createBitmap(Bitmap origin);

    void drawDst(Canvas canvas);

}
