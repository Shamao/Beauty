package beauty.louise.com.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import beauty.louise.com.R;
import buykee.com.common.view.drawable.PlaceHolderDrawable;


/**
 * Created by Steam on 2017/2/9.
 */

public class GlideUtils {
    private static final String mTag = GlideUtils.class.getSimpleName();

    public static DrawableRequestBuilder displayImagePlaceHolder(Context context, int resId, String url) {
        DrawableRequestBuilder builder = Glide.with(context).load(url);
        if (resId > 0) {
            builder.placeholder(resId)
                    .error(resId);
        }
        return builder.centerCrop().diskCacheStrategy(DiskCacheStrategy.SOURCE);
    }

    public static DrawableRequestBuilder displayImagePlaceHolder(Context context, Drawable drawable, String url) {
        DrawableRequestBuilder builder = Glide.with(context).load(url);
        if (drawable != null) {
            builder.placeholder(drawable)
                    .error(drawable);
        }
        return builder.centerCrop().diskCacheStrategy(DiskCacheStrategy.SOURCE);
    }

    public static DrawableRequestBuilder displayImageByRate(Context context, String url) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ph_planet);
        PlaceHolderDrawable drawable = new PlaceHolderDrawable(bitmap);
        DrawableRequestBuilder builder = GlideUtils.displayImagePlaceHolder(context, drawable, url);
        return builder;
    }

}
