package com.louise.base.net.interceptor;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.louise.base.utils.NetUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author lsd
 * @date 2018/2/7.
 */

public class CacheInterceptor implements Interceptor {

    private Context mContext;

    public CacheInterceptor(Context context) {
        this.mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (NetUtils.isNetworkAvailable(mContext)) {
            Response response = chain.proceed(request);
            // read from cache for 60 s
            int maxAge = 60;
            String cacheControl = request.cacheControl().toString();
            Log.e("Tamic", "60s load cahe" + cacheControl);
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        } else {

            ((Activity) mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(mContext, "当前无网络! 为你智能加载缓存", Toast.LENGTH_SHORT).show();
                }
            });
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Response response = chain.proceed(request);
            //set cahe times is 3 days
            int maxStale = 60 * 60 * 24 * 3;
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    }
}