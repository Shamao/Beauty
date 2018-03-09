package com.louise.base.net;

import com.louise.base.utils.Logger;
import com.louise.base.utils.constance.ConstTag;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author lsd
 * @date 2018/3/7.
 */

public class BeautyObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        Logger.d(ConstTag.S_RETROFIT, "onSubscribe");
    }

    @Override
    public void onNext(T t) {
        Logger.d(ConstTag.S_RETROFIT, "onNext");
    }

    @Override
    public void onError(Throwable e) {
        Logger.d(ConstTag.S_RETROFIT, "onError");

    }

    @Override
    public void onComplete() {
        Logger.d(ConstTag.S_RETROFIT, "onSubscribe");

    }
}
