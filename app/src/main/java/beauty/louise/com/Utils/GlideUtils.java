package beauty.louise.com.Utils;

import android.content.Context;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import beauty.louise.com.R;


/**
 * Created by Steam on 2017/2/9.
 */

public class GlideUtils {


    public static DrawableRequestBuilder displayImagePlaceHolder(Context context, int resId, String url) {
        DrawableRequestBuilder builder = Glide.with(context).load(url);
        if (resId > 0) {
            builder.placeholder(resId)
                    .error(resId);
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

        float ratioH = widthWeight * 1.0f / heightWeight;

        if (ratioH == 0.5) {
            builder = GlideUtils.displayImage1_2(context, url);
        } else if (ratioH == 1) {
            builder = GlideUtils.displayImage1_1(context, url);
        } else if (ratioH == 2) {
            builder = GlideUtils.displayImage2_1(context, url);
        } else if (ratioH == 3) {
            builder = GlideUtils.displayImage3_1(context, url);
        } else {
            float ratioV = heightWeight * 1.0f / widthWeight;
            if (ratioV == 0.6) {
                builder = GlideUtils.displayImage5_3(context, url);
            } else if (ratioV == 0.75) {
                builder = GlideUtils.displayImage4_3(context, url);
            } else if (ratioV == 2) {
                builder = GlideUtils.displayImage1_2(context, url);
            }
        }

        if (builder == null) {
            builder = GlideUtils.displayImagePlaceHolder(context, R.drawable.ph_planet, url);
        }

        return builder;
    }

    public static DrawableRequestBuilder displayImage1_1(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.ph_planet)
                .error(R.drawable.ph_planet);
    }

    public static DrawableRequestBuilder displayImage2_1(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.ph_planet)
                .error(R.drawable.ph_planet)
                ;

    }

    public static DrawableRequestBuilder displayImage3_1(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.ph_planet)
                .error(R.drawable.ph_planet)
                ;
    }


    public static DrawableRequestBuilder displayImage5_3(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.ph_planet)
                .error(R.drawable.ph_planet);

    }


    public static DrawableRequestBuilder displayImage4_3(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.ph_planet)
                .error(R.drawable.ph_planet);
    }

    public static DrawableRequestBuilder displayImage1_2(Context context, String url) {
        return Glide.with(context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.ph_planet)
                .error(R.drawable.ph_planet);
    }

}
