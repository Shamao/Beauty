package beauty.louise.com.Utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by lsd on 17/3/1.
 */

public class DisplayUtils {

    public static WindowManager getWindowManager(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm;
    }


    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static int getScreenWidth(Context context) {
        WindowManager wm = getWindowManager(context);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        WindowManager wm = getWindowManager(context);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }

    public static float getDensity(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return displayMetrics.density;
    }

    public static int dp2px(Context context,int dp){
        return (int) (getDensity(context)*dp+0.5);
    }

    public static int px2dp(Context context,int dp){
        return (int) (dp/(getDensity(context)*1.f)+0.5);
    }
}
