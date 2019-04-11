package com.louise.base.utils;

import android.util.Log;

import com.louise.base.BuildConfig;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/31 0031.
 */
public class ALogger {

    enum Level {
        error, debug, warn, info, verbose
    }

    private ALogger() {
    }

    /**
     * 打印数据
     *
     * @param level
     * @param tag
     * @param content
     */
    private static void print(Level level, String tag, String content) {
        switch (level) {
            case error:
                Log.e(tag, content);
                break;
            case debug:
                Log.d(tag, content);
                break;
            case warn:
                Log.w(tag, content);
                break;
            case info:
                Log.i(tag, content);
                break;
            case verbose:
                Log.v(tag, content);
                break;
        }

    }

    /**
     * 转换数据
     *
     * @param tag
     * @param t
     * @param <T>
     */
    private static <T> void convert(Level level, String tag, T[] t) {
        if (!BuildConfig.LOG_DEBUG) {
            return;
        }

        if (t == null || t.length == 0) {
            Log.d(tag, " 你呀的有病啊 ，没数据还让我打印 ，看代码去");
            return;
        }

        StringBuilder builder = new StringBuilder();
        //        builder.append(".\n");
        //        builder.append(TOP_BORDER);
        //        builder.append("\n");
        builder.append(tag);
        builder.append("===>");
        for (int i = 0; i < t.length; i++) {
            String content;
            if (t[i] instanceof Object[]) {
                content = Arrays.toString(((T[]) t[i]));
            } else {
                content = String.valueOf(t[i]);
            }
            builder.append(content);
            if (i != t.length - 1) {
                builder.append("-");
            }
        }
        //        builder.append("\n");
        //        builder.append(BOTTOM_BORDER);
        print(level, tag, builder.toString());
    }

    public static <T> void e(final String tag, final T... contents) {
        convert(Level.error, tag, contents);
    }

    public static <T> void v(final String tag, final T... contents) {
        convert(Level.verbose, tag, contents);
    }

    public static <T> void w(final String tag, final T... contents) {
        convert(Level.warn, tag, contents);
    }

    public static <T> void i(final String tag, final T... contents) {
        convert(Level.info, tag, contents);
    }

    public static <T> void d(final String tag, final T... contents) {
        convert(Level.debug, tag, contents);
    }

}
