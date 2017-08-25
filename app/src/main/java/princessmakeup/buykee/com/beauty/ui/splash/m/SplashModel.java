package princessmakeup.buykee.com.beauty.ui.splash.m;

import android.content.Context;

import java.util.Map;

import princessmakeup.buykee.com.beauty.base.BasePresenter;
import princessmakeup.buykee.com.beauty.base.IBaseModel;

/**
 * Created by lsd on 17/1/10.
 */

public class SplashModel implements IBaseModel {
    private BasePresenter mBasePresenter;
    private Context mContext;

    public SplashModel(Context context, BasePresenter basePresenter) {
        mContext = context;
        mBasePresenter = basePresenter;
    }


    @Override
    public void loadData(final int category, Map<String, String> params) {
    }
}
