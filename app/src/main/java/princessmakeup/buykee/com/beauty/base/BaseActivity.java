package princessmakeup.buykee.com.beauty.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import princessmakeup.buykee.com.common.utils.Logger;
import princessmakeup.buykee.com.common.utils.ToastUtils;
import princessmakeup.buykee.com.common.utils.constant.ConstTag;


/**
 * Created by Steam on 16/11/25.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    protected P mPresenter;
    protected String tag;


    public abstract int getLayoutId();

    public abstract void initData();

    public abstract void initView(Bundle savedInstanceState);

    public void loadData() {
    }

    public void initListener() {
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initBaseData();
        //initData -->initView-->loadData-->initListener 顺序 或者 直接在initView 按功能分
        initData();

        initView(savedInstanceState);

        loadData();

        initListener();

        if (mPresenter != null) {
            mPresenter.onCreate(savedInstanceState);
        }
    }

    private void initBaseData() {
        ButterKnife.bind(this);
        tag = getClass().getSimpleName();

    }


    /**
     * Finds the topmost view in the current view hierarchy.
     *
     * @return
     */
    public View getRootView() {
        return this.getWindow().getDecorView().getRootView();
    }


    /**
     * 已处理debug和release 减少代码量
     *
     * @param Object
     */
    protected void logger(Object... Object) {
        Logger.d(tag, Object);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Logger.d(ConstTag.LifeCycle, tag + "-onStart");

        if (mPresenter != null) {
            mPresenter.onStart();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mPresenter != null) {
            mPresenter.onReStart();
        }
        Logger.d(ConstTag.LifeCycle, tag + "-onReStart");
    }

    @Override
    protected void onResume() {
        Logger.d(ConstTag.LifeCycle, tag + "-onResume");
        MobclickAgent.onResume(this);
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
        Logger.d(ConstTag.LifeCycle, tag + "-onPause");
        if (mPresenter != null) {
            mPresenter.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(ConstTag.LifeCycle, tag + "-onStop");
        if (mPresenter != null) {
            mPresenter.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        Logger.d(ConstTag.LifeCycle, tag + "-onDestroy");
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String msg) {
//        ToastUtils.show(this, msg, Toast.LENGTH_SHORT);
    }

}
