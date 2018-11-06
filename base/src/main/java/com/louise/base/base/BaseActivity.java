package com.louise.base.base;

/**
 * @author lsd
 * @date 2018/2/6.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.louise.base.utils.Logger;
import com.louise.base.utils.constance.ConstTag;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    protected String mTag;
    protected Unbinder mUnbinder;

    /**
     * only call setContentView(int resId) or setContentView(View view)
     */
    public abstract int getLayoutId();

    /**
     * if getLayoutId() return <= 0, will call this method get rootView for activity
     *
     * @return
     */
    public View getLayoutView() {
        return null;
    }

    /**
     * init data from intent and basic params
     */
    public abstract void initData();

    /**
     * init view
     */
    public abstract void initView(Bundle savedInstanceState);

    /**
     * load Data from net
     */
    public void loadData() {
    }

    /**
     * add listener to view or other(eg:)
     */
    public void initListener() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mTag = getClass().getSimpleName();
        super.onCreate(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        } else if (getLayoutView() != null) {
            setContentView(getLayoutView());
        }

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
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Logger.d(ConstTag.S_LIFE_CYCLE, mTag + "-onNewIntent");
    }
    // ---- ---- ---- ---- ---- ---- ---- ---- ---- ----
}