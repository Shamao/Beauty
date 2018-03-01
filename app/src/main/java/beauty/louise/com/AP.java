package beauty.louise.com;

import com.alibaba.sdk.android.BaseAlibabaSDK;
import com.alibaba.sdk.android.callback.InitResultCallback;
import com.louise.base.base.BaseAP;
import com.louise.base.utils.Logger;

/**
 * @author lsd
 * @date 2018/1/23.
 */

public class AP extends BaseAP {
    @Override
    public void onCreate() {
        super.onCreate();
        initAppLink();
    }

    private void initAppLink() {
        BaseAlibabaSDK.asyncInit(this, new InitResultCallback() {
            @Override
            public void onSuccess() {
                Logger.d("阿里电商", "BaseAlibabaSDK init successed");
            }

            @Override
            public void onFailure(int code, String msg) {
                Logger.e("阿里电商","BaseAlibabaSDK init failed");
            }
        });
    }
}
