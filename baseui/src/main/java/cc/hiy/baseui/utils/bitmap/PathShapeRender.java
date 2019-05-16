package cc.hiy.baseui.utils.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * @author lsd
 * @date 2019/5/16.
 */
public class PathShapeRender implements IShapeRender {

    @Override
    public Bitmap createBitmap(Bitmap origin) {
        return Bitmap.createBitmap(origin.getWidth(), origin.getHeight(), Bitmap.Config.ARGB_8888);
    }

    @Override
    public void drawDst(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);

        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Path path = createPath(width, height);
        canvas.drawPath(path, paint);
    }

    /**
     * 创建 Path
     *
     * @param width
     * @param height
     * @return
     */
    private Path createPath(int width, int height) {
        Path path = new Path();
        path.moveTo(width / 2, 0);
        path.lineTo(0, height);
        path.lineTo(width, height);
        path.close();
        return path;
    }
}
