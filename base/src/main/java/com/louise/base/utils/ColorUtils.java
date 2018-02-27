package com.louise.base.utils;

/**
 * @author lsd
 * @date 2018/2/8.
 */

public class ColorUtils {

    public static int getRandomColor() {
        int a = (int) Math.floor(Math.random() * 255);
        int r = (int) Math.floor(Math.random() * 255);
        int g = (int) Math.floor(Math.random() * 255);
        int b = (int) Math.floor(Math.random() * 255);
        return a << 24 | r << 16 | g << 8 | b;
    }
}
