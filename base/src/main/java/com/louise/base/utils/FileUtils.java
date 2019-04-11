package com.louise.base.utils;

import android.content.Context;
import android.support.annotation.RawRes;

import com.louise.base.utils.constance.ConstTag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author lsd
 * @date 2018/3/1.
 * eg
 */

public class FileUtils {

    public static String readFromRaw(Context context, @RawRes int rawId) {
        StringBuilder builder = new StringBuilder();

        InputStream in = context.getResources().openRawResource(rawId);
        byte[] buffer = new byte[1024];
        try {
            while ((in.read(buffer)) != -1) {
                ALogger.d(ConstTag.S_TODO, buffer);
                builder.append(new String(buffer, 0, 17));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static String readText(InputStream ins) {
        StringBuilder builder = new StringBuilder();

        InputStreamReader reader = new InputStreamReader(ins);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String content;
        try {
            while ((content = bufferedReader.readLine()) != null) {
                builder.append(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
