package beauty.louise.com;

import com.alibaba.sdk.android.BaseAlibabaSDK;
import com.alibaba.sdk.android.callback.InitResultCallback;
import com.louise.base.base.BaseAP;

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
            }

            @Override
            public void onFailure(int code, String msg) {
            }
        });
    }
}
