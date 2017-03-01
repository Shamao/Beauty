package princessmakeup.buykee.com.beauty.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import princessmakeup.buykee.com.beauty.R;
import princessmakeup.buykee.com.beauty.base.BaseFragment;

/**
 * Created by lsd on 17/1/19.
 */

public class HomeFragment extends BaseFragment<MainPresent> {
    private static HomeFragment mHomeFragment;

    @Override
    public int getLayoutId() {
        return R.layout.fragmnet_home;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
    }

    @Override
    protected void loadData() {
        super.loadData();

    }

    public static Fragment newInstance(Bundle bundle) {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
            if (bundle != null) {
                mHomeFragment.getArguments().putAll(bundle);

            }
            return mHomeFragment;
        } else {

            return mHomeFragment;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onSuccess(int category, Object object) {

    }

    @Override
    public void onFailed(Object object) {

    }
}
