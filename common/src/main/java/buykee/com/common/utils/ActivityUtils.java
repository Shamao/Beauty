package buykee.com.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/**
 * Created by lsd on 17/1/12.
 */

public class ActivityUtils {
    private static final int DEFAULT_REQUEST_CODE = 0;

    /**
     * 普通启动Activity
     *
     * @param activity
     * @param clz
     */
    public static void startActivity(Activity activity, Class<? extends Activity> clz) {
        startActivity(activity, clz, null, -1);
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
        startActivity(activity, clz, null, requestCode);
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
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        if (requestCode >= DEFAULT_REQUEST_CODE) {
            activity.startActivityForResult(intent, requestCode);
        } else {
            activity.startActivity(intent);
        }
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

    public static void startActivity(Context context, String action, String uri, int flag) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(action)) {
            intent.setAction(action);
        }

        if (!TextUtils.isEmpty(uri)) {
            intent.setData(Uri.parse(uri));
        }

        if (flag > 0) {
            intent.setFlags(flag);
        }

        context.startActivity(intent);
    }

}
