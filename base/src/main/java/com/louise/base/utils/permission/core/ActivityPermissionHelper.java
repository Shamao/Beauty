package com.louise.base.utils.permission.core;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;

/**
 * @author lsd
 * @date 2019/5/20.
 */
public class ActivityPermissionHelper extends PermissionHelper<Activity> {

    public ActivityPermissionHelper(Activity host) {
        super(host);
    }

    @Override
    public void requestPermission(int requestCode, String... permissions) {
        ActivityCompat.requestPermissions(host, permissions, requestCode);
    }

}
