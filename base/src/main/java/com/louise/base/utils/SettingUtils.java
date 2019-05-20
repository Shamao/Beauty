package com.louise.base.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

/**
 * @author lsd
 * @date 2019/5/20.
 */
public class SettingUtils {

    /**
     * 跳转到app 对应的设置叶脉呢
     *
     * @param activity
     */
    public static void jumpAppSetting(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                .setData(Uri.fromParts("package", activity.getPackageName(), null));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        int APP_SETTINGS_RC = 7534;
        activity.startActivityForResult(intent, APP_SETTINGS_RC);
    }
}
