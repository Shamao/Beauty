package com.louise.base.utils;

import java.util.List;

/**
 * @author lsd
 * @date 2018/2/6.
 */

public class ArrayUtils {

    public static <T> boolean isEmpty(T[] a) {
        return a == null || a.length == 0;
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean isNotEmpty(T[] a) {
        return a != null && a.length > 0;
    }

    public static boolean isNotEmpty(List<?> list) {
        return list != null && list.size() > 0;
    }


}
