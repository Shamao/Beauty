package buykee.com.common;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import buykee.com.common.base.BaseActivity;

/**
 * @author lsd
 */
@Route(path = "/common/common")
public class CommonActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return buykee.com.common.R.layout.ac_common;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }


}
