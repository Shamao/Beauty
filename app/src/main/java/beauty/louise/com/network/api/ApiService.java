package beauty.louise.com.network.api;


import java.util.ArrayList;

import okhttp3.ResponseBody;
import beauty.louise.com.bean.base.BaseResult;
import beauty.louise.com.bean.bean.MNoticeCount;
import beauty.louise.com.bean.bean.MProductCate;
import beauty.louise.com.bean.bean.UserBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;


/**
 * Created by Steam on 16/11/24.
 */

public interface ApiService {

    @Streaming
    @GET
    Observable<ResponseBody> downloadFile(@Url String fileUrl);

    @GET("product/catalog-list")
    Observable<BaseResult<ArrayList<MProductCate>>> getProductCatalogList();

    @GET("user/user-notice-count")
    Observable<MNoticeCount> getNoticeCount(@Query("local_ts") long ts);






    @GET("home/info")
    Observable<BaseResult<UserBean>> getHomeInfo(@Query("user_id") String user_id);

}
