package com.louise.base.base.mvp;

import com.louise.base.utils.ALogger;
import com.louise.base.utils.constance.ConstTag;

/**
 * @author lsd
 * @date 2018/3/22.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {
    protected V mView;

    private boolean isFirstLoad;

    protected abstract void initData();

    protected abstract void loadData();

    public BasePresenter(V view) {
        mView = view;
    }

    @Override
    public void onActivityCreate() {
        ALogger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityCreate");
        isFirstLoad = false;
        initData();
    }

    @Override
    public void onActivityStart() {
        ALogger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityStart");
    }

    @Override
    public void onActivityResume() {
        ALogger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityResume");
        if (isFirstLoad) {
            return;
        }
        loadData();
    }

    @Override
    public void onActivityPause() {
        ALogger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityPause");

    }

    @Override
    public void onActivityStop() {
        ALogger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityStop");
    }

    @Override
    public void onActivityDestroy() {
        ALogger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityDestroy");
        mView = null;
    }

    @Override
    public void onActivityRestart() {
        ALogger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityRestart");
    }
}
