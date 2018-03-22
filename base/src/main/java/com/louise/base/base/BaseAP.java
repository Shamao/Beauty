package com.louise.base.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.BuildConfig;
import com.louise.base.net.RetrofitManager;
import com.louise.base.utils.ActivityStack;

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

        registerActivityListener();
    }


    private void registerActivityListener() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                ActivityStack.getInstance().addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                ActivityStack.getInstance().removeActivity(activity);
            }
        });
    }
}