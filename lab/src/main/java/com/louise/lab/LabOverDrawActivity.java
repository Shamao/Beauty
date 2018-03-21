package com.louise.lab;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;

/**
 * @author lsd
 * @date 2018/3/20.
 */
@Route(path = "/lab/overdraw")
public class LabOverDrawActivity extends BaseActivity {
    @Override
    public void initContentLayout() {
        setContentView(R.layout.lab_ac_over_draw);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }
}
