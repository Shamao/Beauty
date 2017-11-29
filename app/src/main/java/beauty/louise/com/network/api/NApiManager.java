package beauty.louise.com.network.api;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import beauty.louise.com.CosmeApp;
import beauty.louise.com.Utils.SecurityUtils;
import buykee.com.common.utils.AppUtils;
import buykee.com.common.utils.DisplayUtils;
import beauty.louise.com.Utils.GsonUtils;
import buykee.com.common.utils.NetUtils;
import buykee.com.common.utils.constant.ConstTag;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Steam on 16/11/24.
 */

public class NApiManager {

    public static String BASE_URL = "https://napi.cosmeapp.com";
    public static String API_VERSION = "/v8/";
    public static final String CODE = "WBs26POHEDCOI0T9Amk2RdrMXwgJ35HP";

    public static ApiService getNApiService() {

        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.d(ConstTag.Retrofit, message);
                    }
                });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //缓存地址
        File httpCacheDirectory = new File(
                CosmeApp.getInstance().getExternalCacheDir(), "responses");

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .cache(new Cache(httpCacheDirectory, 10 * 1024 * 1024))
                .addInterceptor(new CustomParameterInterceptor())
                .addInterceptor(new CacheInterceptor())
                .addNetworkInterceptor(new CacheInterceptor());

        //debug时 log
        if (AppUtils.isDebuggable(CosmeApp.getInstance())) {
            clientBuilder.addInterceptor(httpLoggingInterceptor);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(GsonUtils.getInstance().getGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(getBaseUrl())
                .build();

        return retrofit.create(ApiService.class);
    }

    /**
     * 缓存拦截器
     */
    public static class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetUtils.isConnected(CosmeApp.getInstance())) {  //离线时只取缓存
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);

            if (NetUtils.isConnected(CosmeApp.getInstance())) {
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=10")
                        .build();
            } else {  //离线缓存
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=604800")
                        .build();
            }
        }
    }

    /**
     * 拦截器，添加全局基础公共参数
     */
    public static class CustomParameterInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            String session_id = "0";

            Request request = chain.request();
            HttpUrl httpUrl = request.url().newBuilder()
                    .addQueryParameter("auth_type", "session")
                    .addQueryParameter("session_id", session_id)
                    .addQueryParameter("mid", DisplayUtils.getDeviceId(CosmeApp.getInstance()))
                    .addQueryParameter("image_size", getImageSize(CosmeApp.getInstance()) + "")
                    .addQueryParameter("client_version", AppUtils.getVersionName(CosmeApp.getInstance()))
                    .addQueryParameter("client_version_code", AppUtils.getVersionCode(CosmeApp.getInstance()) + "")
                    .addQueryParameter("client_channel", AppUtils.getAppChannel(CosmeApp.getInstance()))
                    .addQueryParameter("client_device", AppUtils.getDeviceInfo())
                    .addQueryParameter("from_device", "android")
                    .addQueryParameter("width", DisplayUtils.getScreenWidth(CosmeApp.getInstance()) + "")
                    .addQueryParameter("height", DisplayUtils.getScreenHeight(CosmeApp.getInstance()) + "")
                    .build();
            request = request.newBuilder().url(httpUrl).build();
            request = SecurityUtils.signRequest(request);

            return chain.proceed(request);
        }
    }

    public static String getBaseUrl() {
        return BASE_URL + API_VERSION;
    }

    /**
     * 获取矫正后的时间戳
     *
     * @return
     */
    public static String getTs() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String getImageSize(Context context) {
        if (DisplayUtils.getScreenWidth(context) < 640) {
            return "480";
        }
        return "640";
    }

}
