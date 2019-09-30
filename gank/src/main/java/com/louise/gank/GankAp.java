package com.louise.gank;

import com.louise.base.base.BaseAP;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author lsd
 * @date 2019/5/12.
 */
public class GankAp extends BaseAP {

    @Override
    public void onCreate() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        super.onCreate();
        // Normal app init code...

        RoomHelper.init(this);
    }
}
