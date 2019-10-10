package com.louise.gank.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.louise.base.utils.ALogger;

/**
 * @author lsd
 * @date 2019/10/10.
 */
@Interceptor(priority = 8)
public class UserInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        ALogger.d("Arouter", "UserInterceptor");
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {

    }
}
