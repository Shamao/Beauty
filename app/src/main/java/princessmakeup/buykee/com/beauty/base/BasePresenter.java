package princessmakeup.buykee.com.beauty.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Steam on 16/12/20.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    protected V mView;
    private CompositeSubscription mCompositeSubscription;

    protected boolean mFirstLoad = true;

    public BasePresenter(V view) {
        attachView(view);
    }


    /**
     * 绑定View
     *
     * @param view
     */
    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    /**
     * 解绑View
     */
    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }

    /**
     * 使用异步操作时需要调用，防止内存泄露
     *
     * @param subscription
     */
    @Override
    public void addSubscription(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    /**
     * 订阅
     */
    @Override
    public void subscribe() {
    }

    /**
     * 生命周期结束时取消异步回调
     */
    @Override
    public void unSubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void onSuccess(int category, Object object) {
        mView.onSuccess(category, object);
    }

    @Override
    public void onFailed(Object object) {
        mView.onFailed(object);
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
    }

    public void onReStart() {

    }

    public void onStart() {
    }

    public void onResume() {
        subscribe();
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }


}