package beauty.louise.com.network.rx;


import beauty.louise.com.network.api.HttpResultFunc;
import beauty.louise.com.bean.base.BaseResult;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Steam on 16/11/25.
 */

public class RxJavaHelper {

    /**
     * 基础切换线程操作
     *
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<T, T> observeOnMainThread() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<BaseResult<T>, T> observeOnMainThreadWithMap() {
        return new Observable.Transformer<BaseResult<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseResult<T>> baseResultObservable) {
                return baseResultObservable.map(new HttpResultFunc<T>())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
