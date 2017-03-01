package princessmakeup.buykee.com.beauty.base;

import android.content.Context;

/**
 * Created by Steam on 16/12/20.
 */

public interface IBaseView {

    void showLoading();

    void hideLoading();

    void showMessage(String msg);

    void onSuccess(int category, Object object);

    void onFailed(Object object);

    Context getContext();

}
