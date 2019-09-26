package beauty.louise.com;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;

import beauty.louise.com.view.NoScrollViewPager;

/**
 * @author ssss
 */
@Route(path = "/main/main")
public class MainActivity extends BaseActivity {



    @Override
    public int getLayoutId() {
        return R.layout.ac_main;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
    }

}
