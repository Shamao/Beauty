package princessmakeup.buykee.com.beauty.ui.weex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;

import princessmakeup.buykee.com.beauty.R;

public class WeexActivity extends AppCompatActivity implements IWXRenderListener {

    private ViewGroup mContainer;
    private WXSDKInstance mInstance;
    private ImageView mIvGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weex);

        mInstance = new WXSDKInstance(this);
        mInstance.registerRenderListener(this);

        /**
         * WXSample 可以替换成自定义的字符串，针对埋点有效。
         * template 是.we transform 后的 js文件。
         * option 可以为空，或者通过option传入 js需要的参数。例如bundle js的地址等。
         * jsonInitData 可以为空。
         * width 为-1 默认全屏，可以自己定制。
         * height =-1 默认全屏，可以自己定制。
         */
        mInstance
                .renderByUrl("WXSample", "http://192.168.2.23:9898/dist/app.weex.js", null, null,
                             WXRenderStrategy.APPEND_ASYNC);

        mIvGif = (ImageView) findViewById(R.id.iv_gif);
//        Glide.with(this).load(R.drawable.ic_app_property).asGif().into(mIvGif);

    }

    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
        setContentView(view);
    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mInstance != null) {
            mInstance.onActivityResume();
        }
    }

    @Override
    protected void onStop() {
        super.onPause();
        if (mInstance != null) {
            mInstance.onActivityStop();
        }
    }
}
