package com.louise.base.net;

import android.content.Context;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.louise.base.net.interceptor.CacheInterceptor;
import com.louise.base.net.interceptor.ParamsInterceptor;
import com.louise.base.utils.constance.ConstTag;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lsd on 16/11/24.
 */

public class RetrofitManager {
    private Context mContext;


    private static File httpCacheDirectory;
    private static OkHttpClient.Builder mOkHttpClientBuilder;
    private static Retrofit.Builder mBuilder;

    public static class Holder {
        public static RetrofitManager mInstance = new RetrofitManager();
    }

    public static RetrofitManager getInstance() {
        return Holder.mInstance;
    }

    public void init(Context context) {
        mContext = context;
        initOkHttpClient();
        initRetrofitClient();
    }

    private void initOkHttpClient() {
        File cacheDir = new File(mContext.getCacheDir(), "cache");
        Cache cache = new Cache(cacheDir, 10 * 1024 * 1024);

        mOkHttpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .cache(cache)
                .addInterceptor(new CacheInterceptor(mContext))
                .addInterceptor(new ParamsInterceptor())
                .addNetworkInterceptor(getHttpLoggingInterceptor());
    }

    private void initRetrofitClient() {
        mBuilder = new Retrofit.Builder()
                .client(mOkHttpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }


    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(ConstTag.S_RETROFIT, message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 外部调用
    ///////////////////////////////////////////////////////////////////////////

    /**
     * API
     *
     * @return
     */
    public <T> T createGankApiService(String baseUrl, Class<T> clazz) {
        return mBuilder.baseUrl(baseUrl).build().create(clazz);
    }
}
