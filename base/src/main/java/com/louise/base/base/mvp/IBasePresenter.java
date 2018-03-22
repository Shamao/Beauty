package com.louise.base.base.mvp;

/**
 * @author lsd
 * @date 2018/3/22.
 */

public interface IBasePresenter {

    void onActivityCreate();

    void onActivityStart();

    void onActivityResume();

    void onActivityPause();

    void onActivityStop();

    void onActivityDestroy();

    void onActivityRestart();
}
