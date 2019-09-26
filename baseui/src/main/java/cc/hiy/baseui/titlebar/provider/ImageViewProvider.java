package cc.hiy.baseui.titlebar.provider;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author lsd
 * @date 2019/5/11.
 */
public class ImageViewProvider extends IViewProvider<ImageView> {

    public ImageViewProvider(Context context) {
        super(context);
    }

    @Override
    ImageView onCreateView(Context context) {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(lp);

        imageView.setAdjustViewBounds(true);
        return imageView;
    }

    public void setImageBitmap(Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }


    public void setImageResource(int resId) {
        view.setImageResource(resId);
    }

}
