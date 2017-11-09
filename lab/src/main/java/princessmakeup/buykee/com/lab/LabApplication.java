package princessmakeup.buykee.com.lab;

import com.alibaba.android.arouter.launcher.ARouter;

import princessmakeup.buykee.com.common.base.BaseApplication;

/**
 * @author lsd
 * @date 2017/11/9.
 */

public class LabApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        initARouter();
    }

    private void initARouter() {
//        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
        ARouter.init(this);
    }

}
