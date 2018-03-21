package com.louise.gank;

import com.louise.base.bean.BaseResult;
import com.louise.base.bean.gank.MGankWelfareBean;
import com.louise.base.net.BeautyObserver;
import com.louise.base.net.RetrofitManager;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lsd
 * @date 2018/3/7.
 */

public class GankApi {

    public interface Callback<T> {
        void onCallback(T t);
    }

    private GankApi() {

    }

    public static class Holder {
        public static GankApi mInstance = new GankApi();
    }

    public static GankApi getInstance() {
        return Holder.mInstance;
    }

    public void getGankWelfare(int pageSize, int page, final Callback<List<MGankWelfareBean>> callback) {
        RetrofitManager.getInstance().createGankApiservice().getGankWelfare("福利", pageSize, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BeautyObserver<BaseResult<List<MGankWelfareBean>>>() {
                    @Override
                    public void onNext(BaseResult<List<MGankWelfareBean>> result) {
                        super.onNext(result);
                        if (callback == null) {
                            return;
                        }
                        callback.onCallback(result.getData());

                    }
                });
    }
}
