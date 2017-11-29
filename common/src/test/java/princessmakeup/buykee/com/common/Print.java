package buykee.com.common;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/31 0031.
 */
public class Print {
    private static final String divider_start = "-a-a-a-a-a-a-a-a-a-a";
    private static final String divider_end = "====================";

    enum Level {
        error, debug, warn, info, verbose
    }

    private Print() {
    }

    private static void println(String content) {
        System.out.println(content);
    }

    /**
     * 转换数据
     *
     * @param t
     * @param <T>
     */
    public static <T> void convert(T[] t) {
        if (t == null || t.length == 0) {
            return;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            String content;
            if (t[i] instanceof Object[]) {
                content = Arrays.toString(((T[]) t[i]));//String.valueOf();
            } else {
                content = String.valueOf(t[i]);
            }

            builder.append(content);
            if (i != t.length - 1) {
                builder.append("-");
            }
        }
        println(builder.toString());
    }

    public static <T> void print(final T... contents) {
        convert(contents);

    }
}
