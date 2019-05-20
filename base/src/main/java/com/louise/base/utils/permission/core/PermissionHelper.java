package com.louise.base.utils.permission.core;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * @author lsd
 * @date 2019/5/20.
 */
public abstract class PermissionHelper<T> {

    T host;

    public static PermissionHelper<Activity> newInstance(Activity activity) {
        return new ActivityPermissionHelper(activity);
    }

    public static PermissionHelper<Fragment> newInstance(Fragment fragment) {
        return new FragmentPermissionHelper(fragment);
    }

    public PermissionHelper(T host) {
        this.host = host;
    }


    public abstract void requestPermission(int requestCode, String... permissions);
}
