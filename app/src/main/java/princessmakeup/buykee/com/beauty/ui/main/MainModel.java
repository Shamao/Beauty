package princessmakeup.buykee.com.beauty.ui.main;

import android.content.Context;

import java.util.Map;

import princessmakeup.buykee.com.beauty.base.BasePresenter;
import princessmakeup.buykee.com.beauty.base.IBaseModel;
import princessmakeup.buykee.com.beauty.bean.bean.UserBean;
import princessmakeup.buykee.com.beauty.network.api.NApi;
import princessmakeup.buykee.com.beauty.network.api.NApiSubscriber;
import princessmakeup.buykee.com.common.utils.constant.ConstCategory;

/**
 * Created by lsd on 17/1/12.
 */

public class MainModel implements IBaseModel {
    private BasePresenter mBasePresenter;
    private Context mContext;

    public MainModel(Context context, BasePresenter basePresenter) {
        mContext = context;
        mBasePresenter = basePresenter;
    }

    @Override
    public void loadData(final int category, Map<String, String> params) {

        if (category == ConstCategory.MAIN_CENTER) {
            NApi.getHomeInfo(new NApiSubscriber<UserBean>(mContext) {
                @Override
                public void onSuccess(UserBean userBean) {
                    mBasePresenter.onSuccess(category, userBean);
                }
            }, params.get("user_id"));
        }

    }
}
