package buykee.com.common.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;


/**
 * Created by Steam on 16/11/25.
 */

public class AppUtils {

    /**
     * 获取是否为debug状态
     *
     * @param context
     * @return
     */
    public static boolean isDebuggable(Context context) {
        boolean debuggable = false;
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            if (packageInfo != null) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                debuggable = (applicationInfo.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return debuggable;
    }

    /**
     * 获取版本号. example 2.6.0
     *
     * @return 当前应用的版本号
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            Log.d("VERSION_NAME", info.versionName);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "unknown";
    }

    /*
     * example 2.5.0
     */
    public static int getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Integer.MAX_VALUE;
    }

    public static String getDeviceInfo() {
        // 设备和设备系统信息
        String deviceInfo = Build.MODEL + "-" + Build.VERSION.RELEASE;
        deviceInfo = deviceInfo.replaceAll(" ", "_");
        return deviceInfo;
    }

    public static String getAppChannel(Context context) {
        ApplicationInfo appInfo = null;
        try {
            appInfo = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
            return appInfo.metaData.getString("UMENG_CHANNEL").replaceAll(" ", "_");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "baidu";
    }
}
