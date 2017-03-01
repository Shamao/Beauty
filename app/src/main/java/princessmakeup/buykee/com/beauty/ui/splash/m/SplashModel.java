package princessmakeup.buykee.com.beauty.ui.splash.m;

import android.content.Context;

import java.util.Map;

import princessmakeup.buykee.com.beauty.base.BasePresenter;
import princessmakeup.buykee.com.beauty.base.IBaseModel;
import princessmakeup.buykee.com.beauty.bean.index.AdBean;
import princessmakeup.buykee.com.beauty.network.api.NApi;
import princessmakeup.buykee.com.beauty.network.api.NApiSubscriber;

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
        NApiSubscriber<AdBean> subscriber = new NApiSubscriber<AdBean>(mContext) {
            @Override
            public void onSuccess(AdBean mIndexAd) {
                mBasePresenter.onSuccess(category,mIndexAd);
            }

            @Override
            public void onFailure(Throwable e) {
                super.onFailure(e);
                mBasePresenter.onFailed(e);
            }
        };
        NApi.getCoopenAd(subscriber);
    }
}
