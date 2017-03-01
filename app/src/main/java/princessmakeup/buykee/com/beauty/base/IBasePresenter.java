package princessmakeup.buykee.com.beauty.base;

import java.util.Map;

import rx.Subscription;

/**
 * Created by Steam on 16/12/15.
 */

public interface IBasePresenter<V extends IBaseView> {
    /**
     * 绑定View
     *
     * @param view
     */
    void attachView(V view);

    /**
     * 解绑View
     */
    void detachView();

    /**
     * 订阅
     */
    void subscribe();

    /**
     * 对异步操作添加统一管理
     *
     * @param subscription
     */
    void addSubscription(Subscription subscription);

    /**
     * 解绑
     */
    void unSubscribe();

    void onSuccess(int category,Object object);

    void onFailed(Object object);// TODO: 17/1/12

    void loadData(int category, Map<String, String> params);

}
