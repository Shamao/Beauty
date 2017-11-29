package buykee.com.common.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2016/7/20 0020.
 */
public abstract class BaseFragmentActivity extends BaseActivity {


    public abstract Fragment newInstance();

    public abstract int getContainerId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().add(getContainerId(), newInstance()).commit();
    }

    public void replace(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(getContainerId(), newInstance()).commit();
    }

}