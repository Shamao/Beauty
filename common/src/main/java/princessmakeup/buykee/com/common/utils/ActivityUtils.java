package princessmakeup.buykee.com.common.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by lsd on 17/1/12.
 */

public class ActivityUtils {
    private static final int DEFAULT_REQUEST_CODE = -1;

    //普通启动Activity
    public static void startActivity(Activity activity, Class<? extends Activity> clz) {
        startActivity(activity, clz, null, DEFAULT_REQUEST_CODE);
    }

    //带数据无返回
    public static void startActivity(Activity activity, Class<? extends Activity> clz, Bundle bundle) {
        startActivity(activity, clz, bundle, DEFAULT_REQUEST_CODE);
    }

    //不带数据有返回
    public static void startActivity(Activity activity, Class<? extends Activity> clz, int requestCode) {
        startActivity(activity, clz, null, requestCode);
    }

    //real
    public static void startActivity(Activity activity, Class<? extends Activity> clz, Bundle bundle, int requestCode) {
        if (activity == null) {
            throw new NullPointerException("the activity is null in ActivityUtils.class");
        }

        Intent intent = new Intent(activity, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        if (requestCode > DEFAULT_REQUEST_CODE) {
            //            activity.startActivity(intent);
        } else {
            activity.startActivityForResult(intent, requestCode);
        }

        //can give a default animation
    }
}
