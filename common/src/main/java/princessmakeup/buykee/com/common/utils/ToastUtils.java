package princessmakeup.buykee.com.common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Steam on 16/11/25.
 */

public class ToastUtils {
    private static Toast toast;

    /**
     * 短时间显示  Toast
     *
     * @param context
     * @param sequence
     */
    public static void showShort(Context context, CharSequence sequence) {
        if (toast == null) {
            toast = Toast.makeText(context, sequence, Toast.LENGTH_SHORT);
        } else {
            toast.setText(sequence);
        }
        toast.show();

    }
}
