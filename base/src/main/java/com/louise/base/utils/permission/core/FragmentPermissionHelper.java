package com.louise.base.utils.permission.core;

import android.support.v4.app.Fragment;

/**
 * @author lsd
 * @date 2019/5/20.
 */
public class FragmentPermissionHelper extends PermissionHelper<Fragment> {



    public FragmentPermissionHelper(Fragment host) {
        super(host);
    }

    @Override
    public void requestPermission(int requestCode, String... permissions) {
        host.requestPermissions(permissions, requestCode);
    }

}
