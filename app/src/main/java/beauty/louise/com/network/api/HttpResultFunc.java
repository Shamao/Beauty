package beauty.louise.com.network.api;


import beauty.louise.com.Utils.exception.ApiException;
import beauty.louise.com.bean.base.BaseResult;
import rx.functions.Func1;

/**
 *  全局处理接口外层结构，直接暴露出Data，不关心status
 *  如果需要status则不使用就好
 * Created by Steam on 16/11/25.
 * @param <T>
 */

public class HttpResultFunc<T> implements Func1<BaseResult<T>, T> {

    @Override
    public T call(BaseResult<T> tBaseResult) {
        int status = tBaseResult.getStatus();
        if(status == 0){
            throw new ApiException(status, tBaseResult.getMsg());
        }else{
            return tBaseResult.getData();
        }
    }
}
