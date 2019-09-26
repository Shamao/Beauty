package com.louise.gank;

import android.view.View;

public class DoubleClickHelper {

    private static long mStartTime = 0L;

    public static void checkDoubleClick(View.OnClickListener listener) {
        long endTime = System.currentTimeMillis();
        if (endTime - mStartTime <= 800L) {
            if (listener != null) {
                listener.onClick(null);
            }
            mStartTime = 0L;
        } else {
            mStartTime = System.currentTimeMillis();
        }
    }
}
