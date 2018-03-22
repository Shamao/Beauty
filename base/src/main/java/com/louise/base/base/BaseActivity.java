package com.louise.base.base;

/**
 * @author lsd
 * @date 2018/2/6.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.louise.base.utils.Logger;
import com.louise.base.utils.constance.ConstTag;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    protected String mTag;
    protected Unbinder mUnbinder;

    public abstract void initContentLayout();

    public abstract void initData();

    public abstract void initView(Bundle savedInstanceState);

    public void loadData() {
    }

    public void initListener() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mTag = getClass().getSimpleName();
        Logger.d(ConstTag.S_LIFE_CYCLE, mTag + "-onCreate");
        super.onCreate(savedInstanceState);
        initContentLayout();
        initInnerData();
        initInnerView(savedInstanceState);

        initListener();

        loadData();

    }

    private void initInnerView(Bundle savedInstanceState) {
        initView(savedInstanceState);
    }

    private void initInnerData() {
        mTag = getClass().getSimpleName() + "@" + hashCode();
        initData();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Logger.d(ConstTag.S_LIFE_CYCLE, mTag + "-onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.d(ConstTag.S_LIFE_CYCLE, mTag + "-onReStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d(ConstTag.S_LIFE_CYCLE, mTag + "-onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d(ConstTag.S_LIFE_CYCLE, mTag + "-onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(ConstTag.S_LIFE_CYCLE, mTag + "-onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(ConstTag.S_LIFE_CYCLE, mTag + "-onDestroy");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Logger.d(ConstTag.S_LIFE_CYCLE, mTag + "-onNewIntent");
    }
    // ---- ---- ---- ---- ---- ---- ---- ---- ---- ----
}