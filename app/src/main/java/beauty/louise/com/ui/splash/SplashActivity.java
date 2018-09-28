package beauty.louise.com.ui.splash;

import android.os.Bundle;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.base.BaseActivity;

import beauty.louise.com.R;


/**
 * 启动页 功能需要简单 最多加载图片和gif
 *
 * @author ssss
 */
public class SplashActivity extends BaseActivity {
    private ImageView mCoverIv;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.ac_splash);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mCoverIv = findViewById(R.id.cover_iv);
        mCoverIv.postDelayed(new Runnable() {
            @Override
            public void run() {
                ARouter.getInstance().build("/main/main").navigation();
            }
        }, 500);
    }
}
