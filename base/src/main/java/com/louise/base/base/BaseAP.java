package com.louise.base.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.BuildConfig;
import com.louise.base.net.RetrofitManager;
import com.louise.base.utils.ActivityStack;
import com.louise.base.utils.Logger;
import com.louise.base.utils.constance.ConstTag;

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
                Logger.d(ConstTag.S_LIFE_CYCLE, activity.getClass().getSimpleName() + "-onActivityCreated" + activity.hashCode());
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Logger.d(ConstTag.S_LIFE_CYCLE, activity.getClass().getSimpleName() + "-onActivityStarted" + activity.hashCode());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Logger.d(ConstTag.S_LIFE_CYCLE, activity.getClass().getSimpleName() + "-onActivityStarted" + activity.hashCode());
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Logger.d(ConstTag.S_LIFE_CYCLE, activity.getClass().getSimpleName() + "-onActivityDestroyed" + activity.hashCode());
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Logger.d(ConstTag.S_LIFE_CYCLE, activity.getClass().getSimpleName() + "-onActivityDestroyed" + activity.hashCode());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Logger.d(ConstTag.S_LIFE_CYCLE, activity.getClass().getSimpleName() + "-onActivityDestroyed" + activity.hashCode());
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Logger.d(ConstTag.S_LIFE_CYCLE, activity.getClass().getSimpleName() + "-onActivityDestroyed" + activity.hashCode());
                ActivityStack.getInstance().removeActivity(activity);
            }
        });
    }
}