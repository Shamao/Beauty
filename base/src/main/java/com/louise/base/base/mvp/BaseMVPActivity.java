package com.louise.base.base.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.louise.base.base.BaseActivity;

/**
 * @author lsd
 * @date 2018/3/5.
 */

 public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity implements IBaseView {
    private P mPresenter;

    protected abstract P initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = initPresenter();
        if (mPresenter == null) {
            throw new NullPointerException("P 没有初始化");
        }
        mPresenter.onActivityCreate();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        mPresenter.onActivityStart();
        super.onStart();
    }

    @Override
    protected void onRestart() {
        mPresenter.onActivityRestart();
        super.onRestart();
    }

    @Override
    protected void onResume() {
        mPresenter.onActivityResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mPresenter.onActivityPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        mPresenter.onActivityStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onActivityDestroy();
        super.onDestroy();
    }

    // ---- ---- ---- ---- ---- ---- ---- ---- ---- ----


    @Override
    public Intent getIntentAlias() {
        return getIntent();
    }

    @Override
    public Bundle getArgumentAlias() {
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }
        return intent.getExtras();
    }

    @Override
    public Context getContext() {
        return this;
    }
}


