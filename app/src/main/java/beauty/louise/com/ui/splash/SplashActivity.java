package beauty.louise.com.ui.splash;

import android.os.Bundle;
import android.widget.ImageView;

import com.louise.base.base.BaseActivity;

import beauty.louise.com.R;


/**
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
    }

    private void startAnimator() {

    }
}
