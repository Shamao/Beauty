package beauty.louise.com;

import android.support.multidex.MultiDexApplication;
import android.webkit.WebView;

import com.taobao.hotfix.HotFixManager;
import com.taobao.hotfix.PatchLoadStatusListener;
import com.taobao.hotfix.util.PatchStatusCode;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;

import beauty.louise.com.ui.weex.ImageAdapter;
import princessmakeup.buykee.com.common.utils.CommonUtils;

/**
 * Created by Steam on 16/11/25.
 */

public class CosmeApp extends MultiDexApplication {

    public static CosmeApp mCosmeApp;
    public static WebView mWebView;
    public static String mUserAgent;
    public static String appVersion;
    public static String appId;

    @Override
    public void onCreate() {
        CommonUtils.printNanoTimeTime();
        super.onCreate();

        init();
        CommonUtils.printNanoTimeTime();

    }

    private void init() {
        initCommon();

        initHotFix();

        initWeex();
    }


    private void initCommon() {
        mCosmeApp = this;
        mWebView = new WebView(this.getApplicationContext());
        mUserAgent = mWebView.getSettings().getUserAgentString();
    }

    private void initWeex() {
//        InitConfig config = new InitConfig.Builder().setImgAdapter(new ImageAdapter()).build();
//        WXSDKEngine.initialize(this, config);
    }

    private void initHotFix() {
        this.appId = "83351-1"; //替换掉自己应用的appId
        try {
            this.appVersion = this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
        } catch (Exception e) {
            this.appVersion = "1.0.0";
        }

        HotFixManager.getInstance().setContext(this)
                .setAppVersion(appVersion)
                .setAppId(appId)
                .setAesKey(null)
                .setSupportHotpatch(true)
                .setEnableDebug(true)
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onload(final int mode, final int code, final String info, final int handlePatchVersion) {
                        // 补丁加载回调通知
                        if (code == PatchStatusCode.CODE_SUCCESS_LOAD) {
                            // TODO: 10/24/16 表明补丁加载成功
                        } else if (code == PatchStatusCode.CODE_ERROR_NEEDRESTART) {
                            // TODO: 10/24/16 表明新补丁生效需要重启. 业务方可自行实现逻辑, 提示用户或者强制重启, 建议: 用户可以监听进入后台事件, 然后应用自杀
                        } else if (code == PatchStatusCode.CODE_ERROR_INNERENGINEFAIL) {
                            // 内部引擎加载异常, 推荐此时清空本地补丁, 但是不清空本地版本号, 防止失败补丁重复加载
                            //HotFixManager.getInstance().cleanPatches(false);
                        } else {
                            // TODO: 10/25/16 其它错误信息, 查看PatchStatusCode类说明
                        }
                    }
                }).initialize();
    }

    public synchronized static CosmeApp getInstance() {
        return mCosmeApp;
    }

    public WebView getWebView() {
        if (mWebView == null) {
            try {
                mWebView = new WebView(this.getApplicationContext());
            } catch (Exception e) {
            }
        }
        return mWebView;
    }

    public String getUserAgent() {
        if (mUserAgent == null) {
            try {
                mUserAgent = getWebView().getSettings().getUserAgentString();
            } catch (Exception e) {
            }
        }
        return mUserAgent;
    }

    public void redirectSchema(String schema) {
        try {
            //            if (schema != null && !schema.equals("")) {
            //                Uri uri = Uri.parse(schema);
            //                Activity activity = AppManager.getInstance().currentActivity();
            //                if (uri.getQueryParameter("needlogin") != null
            //                        && uri.getQueryParameter("needlogin").equals("1")
            //                        && !LoginUserDb.getInstance().isLogin()) {
            //                    shouldLoginBeforeActions();
            //                } else {
            //                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            //                    activity.startActivity(intent);
            //                }
            //            }
        } catch (Exception e) {
        }
    }


}
