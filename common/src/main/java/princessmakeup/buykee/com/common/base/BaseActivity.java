package princessmakeup.buykee.com.common.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import princessmakeup.buykee.com.common.manager.AppManager;
import princessmakeup.buykee.com.common.utils.Logger;
import princessmakeup.buykee.com.common.utils.constant.ConstTag;


/**
 * Created by lsd on 16/11/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected String mTag;

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
}
