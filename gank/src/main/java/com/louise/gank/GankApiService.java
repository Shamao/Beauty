package com.louise.gank;

import com.louise.base.bean.BaseResult;
import com.louise.base.bean.gank.MGankWelfareBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author lsd
 * @date 2018/2/7.
 */

public interface GankApiService{
    public static final String S_BASE_URL = "http://gank.io";

    @GET("api/data/{category}/{count}/{page}")
    Observable<BaseResult<List<MGankWelfareBean>>> getGankWelfare(@Path("category") String category, @Path("count") int pageSize, @Path("page") int page);

}
