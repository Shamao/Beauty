package com.louise.gank;

import com.louise.base.bean.BaseResult;
import com.louise.base.bean.gank.MGankWelfareBean;
import com.louise.base.net.BeautyObserver;
import com.louise.base.net.RetrofitManager;
import com.louise.base.net.apiservice.BaseApi;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Gank Api请求类
 *
 * @author lsd
 * @date 2018/3/7.
 */

public class GankApi extends BaseApi {

    public interface Callback<T> {
        void onCallback(T t);
    }

    private GankApi() {
    }

    public static class Holder {
        static GankApi mInstance = new GankApi();
    }

    public static GankApi getInstance() {
        return Holder.mInstance;
    }

    private GankApiService mGankApiService;

    public GankApiService getGankApi() {
        if (mGankApiService == null) {
            mGankApiService = RetrofitManager.getInstance().createGankApiService(GankApiService.S_BASE_URL,
                    GankApiService.class);
        }
        return mGankApiService;
    }

    public void getGankWelfare(int pageSize, int page, final Callback<List<MGankWelfareBean>> callback) {
        getGankApi().getGankWelfare("福利", pageSize, page)
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
