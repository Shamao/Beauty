package princessmakeup.buykee.com.beauty.network.api;


import java.util.ArrayList;

import princessmakeup.buykee.com.beauty.bean.bean.MNoticeCount;
import princessmakeup.buykee.com.beauty.bean.bean.MProductCate;
import princessmakeup.buykee.com.beauty.bean.bean.UserBean;
import princessmakeup.buykee.com.beauty.network.rx.RxJavaHelper;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static princessmakeup.buykee.com.beauty.network.api.NApiManager.getNApiService;

/**
 * Created by Steam on 16/11/25.
 */

public class NApi {



    /**
     *  获取用户信息
     * @param subscriber
     * @param user_id
     */
    public static void getHomeInfo(NApiSubscriber subscriber, String user_id) {
        NApiManager.getNApiService().getHomeInfo(user_id)
                .compose(RxJavaHelper.<UserBean>observeOnMainThreadWithMap())
                .subscribe(subscriber);
    }

    /**
     * 总分类列表
     *
     * @param subscriber
     */
    public static void getProductCatalogList(NApiSubscriber subscriber) {
        getNApiService().getProductCatalogList()
                .map(new HttpResultFunc<ArrayList<MProductCate>>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void getProductCatalogList1(NApiSubscriber subscriber) {
        getNApiService().getProductCatalogList()
                .compose(RxJavaHelper.<ArrayList<MProductCate>>observeOnMainThreadWithMap())
                .subscribe(subscriber);
    }

    /**
     * 时间校验，基本状态
     *
     * @param subscriber
     */
    public static void getNoticeCount(NApiSubscriber subscriber) {
        long localTs = System.currentTimeMillis() / 1000;
        getNApiService().getNoticeCount(localTs)
                .compose(RxJavaHelper.<MNoticeCount>observeOnMainThread())
                .subscribe(subscriber);
    }
}
