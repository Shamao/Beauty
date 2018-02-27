package com.louise.base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/**
 * @author lsd
 * @date 2018/2/6.
 */

public class ActivityUtils {
    private static final int DEFAULT_REQUEST_CODE = -1;

    /**
     * 普通启动Activity
     *
     * @param activity
     * @param clz
     */
    public static void startActivity(Activity activity, Class<? extends Activity> clz) {
        startActivity(activity, clz, new Bundle(), -1);
    }

    /**
     * 带数据无返回
     *
     * @param activity
     * @param clz
     * @param bundle
     */
    public static void startActivity(Activity activity, Class<? extends Activity> clz, Bundle bundle) {
        startActivity(activity, clz, bundle, -1);
    }

    /**
     * 不带数据有返回
     *
     * @param activity
     * @param clz
     * @param requestCode
     */
    public static void startActivity(Activity activity, Class<? extends Activity> clz, int requestCode) {
        startActivity(activity, clz, new Bundle(), requestCode);
    }

    /**
     * 实际执行的代码
     *
     * @param activity
     * @param clz
     * @param bundle
     * @param requestCode
     */
    public static void startActivity(Activity activity, Class<? extends Activity> clz, Bundle bundle, int requestCode) {
        if (activity == null) {
            throw new NullPointerException("the activity is null in ActivityUtils.class");
        }

        Intent intent = new Intent(activity, clz);
        activity.startActivityForResult(intent, requestCode, bundle);
    }


    /**
     * 适用于不在Activity中的条状
     *
     * @param context
     * @param clz
     * @param bundle
     */
    public static void startActivity(Context context, Class<? extends Activity> clz, Bundle bundle) {
        if (context == null) {
            throw new NullPointerException("the context is null in ActivityUtils.class");
        }

        Intent intent = new Intent(context, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        context.startActivity(intent);
    }

    public static void startActivity(Context context, String action, String[] categories, Integer[] flags,
                                     String data, String dataType) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(action)) {
            intent.setAction(action);
        }

        if (StringUtils.isNotEmpty(action)) {
            intent.setAction(action);
        }

        if (ArrayUtils.isNotEmpty(categories)) {
            for (int i = 0; i < categories.length; i++) {
                intent.addCategory(categories[i]);
            }
        }

        if (ArrayUtils.isNotEmpty(flags)) {
            for (int i = 0; i < flags.length; i++) {
                intent.addFlags(flags[i]);
            }
        }

        if (StringUtils.isNotEmpty(data)) {
            intent.setDataAndType(Uri.parse(data), dataType);
        }

        context.startActivity(intent);
    }
}
