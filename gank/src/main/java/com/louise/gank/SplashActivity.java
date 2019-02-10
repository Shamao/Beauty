package com.louise.gank;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.base.BaseActivity;

@Route(path = "/gank/splash")
public class SplashActivity extends BaseActivity {

    private TextView mSloganTv;
    @Override
    public int getLayoutId() {
        return R.layout.gank_ac_splash;
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mSloganTv = findViewById(R.id.slogan_tv);
        mSloganTv.postDelayed(new Runnable() {
            @Override
            public void run() {
                ARouter.getInstance().build("/gank/main").navigation();
            }
        }, 3000);
    }


}
