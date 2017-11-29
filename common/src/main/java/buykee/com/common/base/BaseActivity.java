package buykee.com.common.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import buykee.com.common.utils.Logger;
import buykee.com.common.manager.AppManager;
import buykee.com.common.utils.constant.ConstTag;
import pub.devrel.easypermissions.EasyPermissions;


/**
 * Created by lsd on 16/11/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected String mTag;
    protected Unbinder mUnbinder;

    public abstract int getLayoutId();

    public abstract void initData();

    public abstract void initView(Bundle savedInstanceState);

    public void loadData() {
    }

    public void initListener() {
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        setContentView(getLayoutId());
        initInnerData();
        Logger.d(ConstTag.LifeCycle, mTag + "-onCreate");
        Logger.d(ConstTag.ActivityStack, AppManager.getInstance().getAllActivities());
        initInnerView(savedInstanceState);

        loadData();

        initListener();

    }

    private void initInnerView(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        initView(savedInstanceState);
    }

    private void initInnerData() {
        mTag = getClass().getSimpleName() + "@" + hashCode();
        initData();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Logger.d(ConstTag.LifeCycle, mTag + "-onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.d(ConstTag.LifeCycle, mTag + "-onReStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d(ConstTag.LifeCycle, mTag + "-onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d(ConstTag.LifeCycle, mTag + "-onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d(ConstTag.LifeCycle, mTag + "-onStop");
    }

    @Override
    protected void onDestroy() {
        AppManager.getInstance().removeActivity(this);
        super.onDestroy();
        Logger.d(ConstTag.LifeCycle, mTag + "-onDestroy");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Logger.d(ConstTag.LifeCycle, mTag + "-onNewIntent");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * 获取activity当前根布局
     * @return
     */
    public View getRootView() {
        return getWindow().getDecorView().findViewById(android.R.id.content);
    }
}
