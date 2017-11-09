package beauty.louise.com;

import android.support.multidex.MultiDexApplication;
import android.webkit.WebView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.youku.cloud.player.YoukuPlayerConfig;

/**
 * Created by Steam on 16/11/25.
 */

public class CosmeApp extends MultiDexApplication {

    public static final String CLIENT_ID_WITH_AD = "93673f8ce4bdade1";//youku
    public static final String CLIENT_SECRET_WITH_AD = "66346a3d8d2c72b98bb560c8d2a6b848";//youku


    public static CosmeApp mCosmeApp;
    public static WebView mWebView;
    public static String mUserAgent;
    public static String appVersion;
    public static String appId;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        initCommon();

        initARouter();

        initWeex();

        initYouku();
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {    // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);        // 尽可能早，推荐在Application中初始化
    }


    private void initYouku() {
        //        youku
        YoukuPlayerConfig.setLog(true);
        //        /**设置client_id和client_secret*/
        YoukuPlayerConfig.setClientIdAndSecret(CLIENT_ID_WITH_AD, CLIENT_SECRET_WITH_AD);
        //        /**sdk初始化*/
        YoukuPlayerConfig.onInitial(this);
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
