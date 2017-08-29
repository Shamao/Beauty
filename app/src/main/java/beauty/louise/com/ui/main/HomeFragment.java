package beauty.louise.com.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import beauty.louise.com.R;
import beauty.louise.com.base.BaseFragment;

/**
 * Created by lsd on 17/1/19.
 */

public class HomeFragment extends BaseFragment {
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
}
