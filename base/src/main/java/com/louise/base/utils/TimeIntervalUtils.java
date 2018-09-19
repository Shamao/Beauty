package com.louise.base.utils;

import java.util.HashMap;

/**
 * 用来计算时间间隔的
 *
 * @author liusaideng
 * @date 2018/9/19 下午1:50
 */
public class TimeIntervalUtils {

    private static HashMap<String, Long> mStartTimeMap = new HashMap<>();

    public static void addStartTime(String key) {
        long start = System.currentTimeMillis();
        mStartTimeMap.put(key, start);
    }

    public static long getTimeInterval(String key) {
        long start = mStartTimeMap.get(key);
        mStartTimeMap.remove(key);

        long end = System.currentTimeMillis();
        return end - start;
    }
}
