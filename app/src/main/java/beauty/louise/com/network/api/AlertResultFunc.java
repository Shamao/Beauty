package beauty.louise.com.network.api;


import beauty.louise.com.Utils.exception.HasAlertException;
import beauty.louise.com.bean.AlertData;
import buykee.com.common.base.BaseResult;
import beauty.louise.com.Utils.AlertUtils;
import rx.functions.Func1;

/**
 * Created by Steam on 16/12/13.
 */

public class AlertResultFunc<T extends AlertData>
        implements Func1<BaseResult<? extends AlertData>, T> {

    @Override
    public T call(BaseResult<? extends AlertData> baseResult) {
        try{
            AlertData data = baseResult.getData();
            if(data.getAlert() != null){
                AlertUtils.showAlert(data.getAlert());
                throw new HasAlertException(baseResult.getStatus(), baseResult.getMsg(),
                                            data.getAlert());
            }
            return (T)baseResult.getData();
        }catch (Exception e){
            return null;
        }
    }

}
