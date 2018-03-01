package com.louise.gank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/gank/main")
public class GankMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gank_ac_main);
        getWindow().setEnterTransition(new Fade().setDuration(200));
        getWindow().setExitTransition(new Fade().setDuration(200));
    }

}
