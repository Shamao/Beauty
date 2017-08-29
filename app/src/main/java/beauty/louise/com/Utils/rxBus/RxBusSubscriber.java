package beauty.louise.com.Utils.rxBus;

import rx.Subscriber;

/**
 * Created by lsd on 16/12/15.
 */

public abstract class RxBusSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {
        onEvent(t);
    }

    public abstract void onEvent(T t);
}
