package com.louise.base.utils.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

import com.louise.base.utils.ALogger;
import com.louise.base.utils.permission.core.PermissionHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.annotations.NonNull;


/**
 * 对外 权限申请
 *
 * @author lsd
 * @date 2019/5/20.
 */
public class PermissionUtils {
    public static final String S_TAG = "Permission-Group";

    /**
     * 是否需要执行请求权限
     * <p>
     * 6.0以下  不需要请求权限
     * 6.0及以上 需要请求权限
     *
     * @return
     */
    public static boolean needRequestPermision() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否拥有权限
     *
     * @param permissions
     * @return
     */
    public static String[] isPermissionsGranted(Context context, String... permissions) {
        String[] result = {};
        for (int i = 0; i < permissions.length; i++) {
            String permission = permissions[i];
            if (TextUtils.isEmpty(permission)) {
                continue;
            }

            if (isPermissionGranted(context, permission)) {
                continue;
            }

            result = Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = permission;
        }
        ALogger.d(S_TAG, "need request permission : ", Arrays.toString(result));
        return result;
    }

    /**
     * 判断 拥有单一权限
     *
     * @param context
     * @param permission
     * @return
     */
    public static boolean isPermissionGranted(@NonNull Context context, @NonNull String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }


    /**
     * 是否 存在权限贝禁止 再不提醒
     *
     * @param activity
     * @param permissions
     * @return
     */
    public static String[] isPermissionsDenied(Activity activity, String... permissions) {
        String[] result = {};
        for (int i = 0; i < permissions.length; i++) {
            String permission = permissions[i];
            if (TextUtils.isEmpty(permission)) {
                continue;
            }

            if (!isPermissionDenied(activity, permission)) {
                continue;
            }

            result = Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = permission;
        }
        ALogger.d(S_TAG, "denied permissions: ", Arrays.toString(result));
        return result;
    }

    public static boolean isPermissionDenied(Activity activity, String permission) {
        return !ActivityCompat.shouldShowRequestPermissionRationale(activity, permission) && !isPermissionGranted(activity, permission);
    }


    /**
     * Activity 请求权限
     *
     * @param activity
     * @param permissions
     */
    public static void requestPermissions(Activity activity, int requestCode, String... permissions) {
        PermissionHelper.newInstance(activity).requestPermission(requestCode, permissions);
    }

    /**
     * fragment 请求权限
     *
     * @param fragment
     * @param requestCode
     * @param permissions
     */
    public static void requestPermissions(Fragment fragment, int requestCode, String permissions) {
        PermissionHelper.newInstance(fragment).requestPermission(requestCode, permissions);
    }


    /**
     * 权限申请的回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    public static void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults, OnRequestPermissionsResultListener listener) {
        ALogger.d(S_TAG, requestCode, Arrays.toString(permissions), Arrays.toString(grantResults));

        List<String> grantedPerms = new ArrayList<>();
        List<String> deniedPerms = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            String perm = permissions[i];
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                grantedPerms.add(perm);
            } else {
                deniedPerms.add(perm);
            }
        }

        if (listener != null) {
            listener.onPermissionsGranted(requestCode, grantedPerms);
            listener.onPermissionsDenied(requestCode, deniedPerms);
        }
    }
}
