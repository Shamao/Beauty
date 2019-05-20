package com.louise.base.utils.permission;

import java.util.List;

/**
 * @author lsd
 * @date 2019/5/20.
 */
public interface OnRequestPermissionsResultListener {
    void onPermissionsGranted(int requestCode, List<String> perms);

    void onPermissionsDenied(int requestCode, List<String> perms);
}
