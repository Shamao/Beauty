package princessmakeup.buykee.com.beauty.Utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import princessmakeup.buykee.com.beauty.CosmeApp;
import princessmakeup.buykee.com.beauty.bean.NoticeCount;
import princessmakeup.buykee.com.beauty.network.api.NApiManager;
import princessmakeup.buykee.com.common.utils.AppUtils;

/**
 * Created by lsd on 17/1/19.
 */
public class SecurityUtils {

    private static final String Code = NApiManager.CODE;

    public static String encryptedParamList(TreeMap<String, String> params) {

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().equals("sign")) {
                continue;
            }
            builder.append(entry.getKey());
            builder.append("=");
            builder.append(entry.getValue());
            builder.append("&");
        }
        builder.setLength(builder.length() - 1);
        builder.insert(0, Code);
        builder.append(Code);
        return MD5(builder.toString()).toLowerCase(Locale.US);
    }



    public static Request signRequest(Request request) {
        TreeMap<String, String> params = new TreeMap<>();
        String ts = NoticeCount.getTimeStamp();

        try {
            //url 参数
            HttpUrl httpUrl = request.url();
            for (String key : httpUrl.queryParameterNames()) {
                params.put(key, httpUrl.queryParameter(key));
            }
            params.put("ts", ts);

            //post 参数
            if (request.body() != null && request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    params.put(body.encodedName(i), body.encodedValue(i));
                }
            }

            String sign = encryptedParamList(params);
            String userAgent = CosmeApp.getInstance().getUserAgent() +
                    ",Cosmeapp/" + AppUtils.getVersionName(CosmeApp.getInstance());

            request = request.newBuilder()
                    .addHeader("BY-Sign", sign)
                    .addHeader("BY-TimeStamp", ts)
                    .addHeader("User-Agent", userAgent)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;
    }

    public static String MD5(String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = null;
        try {
            byteArray = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = (byte) byteArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
