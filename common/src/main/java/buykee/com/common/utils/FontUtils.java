package buykee.com.common.utils;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author lsd
 * @date 2017/11/10.
 */

public class FontUtils {
    public static final String DEF_FONT = "iconfont.ttf";

    public static final void injectFont(View rootView) {
        injectFont(rootView, Typeface.createFromAsset(rootView.getContext().getAssets(), DEF_FONT));
    }

    private static void injectFont(View rootView, Typeface typeface) {
        if (rootView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) rootView;
            int childViewCount = viewGroup.getChildCount();
            for (int i = 0; i < childViewCount; i++) {
                injectFont(viewGroup.getChildAt(i), typeface);
            }
        } else if (rootView instanceof TextView) {
            ((TextView) rootView).setTypeface(typeface);
        }
    }
}
