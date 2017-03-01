package princessmakeup.buykee.com.beauty.ui.splash.p;


import java.util.Map;

import princessmakeup.buykee.com.beauty.base.BasePresenter;
import princessmakeup.buykee.com.beauty.base.IBaseModel;
import princessmakeup.buykee.com.beauty.base.IBaseView;
import princessmakeup.buykee.com.beauty.ui.splash.m.SplashModel;

/**
 * Created by lsd on 17/1/10.
 */

public class SplashPresent extends BasePresenter<IBaseView> {
    protected IBaseModel mModel;


    public SplashPresent(IBaseView view) {
        super(view);
        mModel = new SplashModel(view.getContext(), this);
    }

    @Override
    public void loadData(int category, Map<String, String> params) {
        mModel.loadData(category, params);
    }


}
