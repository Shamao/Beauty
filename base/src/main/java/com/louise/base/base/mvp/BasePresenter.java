package com.louise.base.base.mvp;

import com.louise.base.utils.Logger;
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
        Logger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityCreate");
        isFirstLoad = false;
        initData();
    }

    @Override
    public void onActivityStart() {
        Logger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityStart");
    }

    @Override
    public void onActivityResume() {
        Logger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityResume");
        if (isFirstLoad) {
            return;
        }
        loadData();
    }

    @Override
    public void onActivityPause() {
        Logger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityPause");

    }

    @Override
    public void onActivityStop() {
        Logger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityStop");
    }

    @Override
    public void onActivityDestroy() {
        Logger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityDestroy");
        mView = null;
    }

    @Override
    public void onActivityRestart() {
        Logger.d(ConstTag.S_LIFE_CYCLE, "P---> onActivityRestart");
    }
}
