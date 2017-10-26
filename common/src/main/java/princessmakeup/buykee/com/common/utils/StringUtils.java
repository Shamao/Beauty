package princessmakeup.buykee.com.common.utils;

import android.text.TextUtils;

/**
 * 字符串操作工具包
 *
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
public class StringUtils {
    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        return TextUtils.isEmpty(input);
    }

    /**
     * 字符串转整数
     *
     * @param str
     * @param defValue
     * @return
     */
    public static int toInt(String str, int defValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
        }
        return defValue;
    }

    /**
     * 对象转整数
     *
     * @param obj
     * @return 转换异常返回 0
     */
    public static long toLong(String obj) {
        try {
            return Long.parseLong(obj);
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * 对象转float
     *
     * @param str
     * @return 转换异常返回 0
     */
    public static float toFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
        }
        return 0f;
    }

    /**
     * 字符串转布尔值
     *
     * @param b
     * @return 转换异常返回 false
     */
    public static boolean toBool(String b) {
        try {
            return Boolean.parseBoolean(b);
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 字符串转布尔值
     *
     * @param obj
     * @return 转换异常返回 ""
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return "";
        }

        try {
            if (obj.equals("null"))
                return "";
            if (obj != null) {
                if (obj.getClass().equals(String.class)) {
                    return (String) obj;
                }
                return obj.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
