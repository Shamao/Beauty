package com.louise.base.base;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.BuildConfig;
import com.louise.base.net.RetrofitManager;

/**
 * @author lsd
 * @date 2018/1/23.
 */

public class BaseAP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("todo", BuildConfig.DEBUG + "");
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);

        RetrofitManager.getInstance().init(this);
    }
}
