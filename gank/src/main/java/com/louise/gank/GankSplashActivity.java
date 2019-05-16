package com.louise.gank;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.base.BaseActivity;

@Route(path = "/gank/splash")
public class GankSplashActivity extends BaseActivity {

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
        }, 500);

        mSloganTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/gank/main").navigation();
            }
        });
    }


}
