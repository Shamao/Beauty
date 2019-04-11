package com.louise.base.manager;

import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.utils.ActivityUtils;
import com.louise.base.utils.ALogger;
import com.louise.base.utils.constance.Const;
import com.louise.base.utils.constance.ConstTag;

/**
 * @author lsd
 * @date 2018/2/27.
 */

public class RouterManager {

    public static class Holder {
        public static RouterManager instance = new RouterManager();
    }

    public static RouterManager getInstance() {
        return Holder.instance;
    }

    public void navigation(final Context context, final String path) {
        ALogger.d(ConstTag.S_ROUTER, "path", path);
        ARouter.getInstance().build(path).navigation(context, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {
                ALogger.d(ConstTag.S_ROUTER, "onFound");
            }

            @Override
            public void onLost(Postcard postcard) {
                ALogger.d(ConstTag.S_ROUTER, "onLost");
                String scheme =
                        Const.S_PROTOCOL + Const.S_HOST + path;
                ActivityUtils.startActivity(context, Intent.ACTION_VIEW, null, null, scheme, null);
            }

            @Override
            public void onArrival(Postcard postcard) {
                ALogger.d(ConstTag.S_ROUTER, "onArrival");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                ALogger.d(ConstTag.S_ROUTER, "onArrival");
            }
        });
    }

}
