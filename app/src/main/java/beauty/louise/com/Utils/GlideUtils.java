package beauty.louise.com.Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import princessmakeup.buykee.com.common.view.drawable.PlaceHolderDrawable;


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

    //    /**
    //     * 根据长宽比
    //     *
    //     * @param context
    //     * @param url
    //     * @param rate
    //     * @return
    //     */
    public static DrawableRequestBuilder displayImageByRate(Context context, String url, int widthWeight, int heightWeight) {
        DrawableRequestBuilder builder = null;

        //        if (widthWeight < 0 || heightWeight < 0) {
        //            return GlideUtils.displayImagePlaceHolder(context, -1, url);
        //        }

        //        float ratioH = widthWeight * 1.0f / heightWeight;
        float ratioV = heightWeight * 1.0f / widthWeight;
        //        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ph_planet);
        PlaceHolderDrawable drawable = null;
        //        PlaceHolderDrawable drawable = new PlaceHolderDrawable(bitmap);
        builder = GlideUtils.displayImagePlaceHolder(context, drawable, url);
        return builder;
    }

    public static DrawableRequestBuilder displayImage1_1(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE);
        //                .placeholder(R.drawable.ph_planet)
        //                .error(R.drawable.ph_planet);
    }

    public static DrawableRequestBuilder displayImage2_1(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE);
        //                .placeholder(R.drawable.ph_planet)
        //                .error(R.drawable.ph_planet);

    }

    public static DrawableRequestBuilder displayImage3_1(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE);
        //                .placeholder(R.drawable.ph_planet)
        //                .error(R.drawable.ph_planet)
    }


    public static DrawableRequestBuilder displayImage5_3(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE);
        ////                .placeholder(R.drawable.ph_planet)
        ////                .error(R.drawable.ph_planet);

    }


    public static DrawableRequestBuilder displayImage4_3(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE);
        //                .placeholder(R.drawable.ph_planet)
        //                .error(R.drawable.ph_planet);
    }

    public static DrawableRequestBuilder displayImage1_2(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE);
        //                .placeholder(R.drawable.ph_planet)
        //                .error(R.drawable.ph_planet);
    }

}
