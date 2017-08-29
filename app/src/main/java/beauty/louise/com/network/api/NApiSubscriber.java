package beauty.louise.com.network.api;

import android.content.Context;
import android.util.Log;

import beauty.louise.com.Utils.exception.ApiException;
import beauty.louise.com.Utils.exception.HasAlertException;
import beauty.louise.com.ui.views.UIToastUtils;
import princessmakeup.buykee.com.common.utils.AppUtils;
import princessmakeup.buykee.com.common.utils.constant.ConstTag;
import rx.Subscriber;

/**
 * Created by Steam on 16/11/25.
 */

public abstract class NApiSubscriber<T> extends Subscriber<T> {

    protected Context mContext;

    public NApiSubscriber(Context context) {
        this.mContext = context;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.w(ConstTag.Error, e);
        onFailure(e);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    /**
     * 成功回调
     *
     * @param t
     */
    public abstract void onSuccess(T t);

    /**
     * 失败回调
     *
     * @param e
     */
    public void onFailure(Throwable e) {
        if (!AppUtils.isNetworkAvailable(mContext)) {
            UIToastUtils.makeText(mContext, "网络不可用", UIToastUtils.LENGTH_LONG).show();
            return;
        }

        if (e instanceof ApiException) {
            UIToastUtils.makeText(mContext, e.getMessage(), UIToastUtils.LENGTH_LONG).show();
        } else if (e instanceof HasAlertException) {
            return;
        } else {
            UIToastUtils.makeText(mContext, "请求失败，请稍后重试...", UIToastUtils.LENGTH_LONG).show();
        }
    }
}
