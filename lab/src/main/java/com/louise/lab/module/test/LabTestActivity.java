package com.louise.lab.module.test;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.mvp.BaseMVPActivity;
import com.louise.base.utils.Logger;
import com.louise.base.utils.constance.ConstTag;
import com.louise.lab.R;

/**
 * @author lsd
 * @date 2018/3/22.
 */

@Route(path = "/lab/test")
public class LabTestActivity extends BaseMVPActivity<LabTestPresenter> implements ILabTestView {

    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_view;
    }

    @Override
    public void initData() {
        Logger.d(ConstTag.S_LIFE_CYCLE, "View-initData()");
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        Logger.d(ConstTag.S_LIFE_CYCLE, "View-initView()");

    }

    @Override
    protected LabTestPresenter initPresenter() {
        Logger.d(ConstTag.S_LIFE_CYCLE, "View-initPresenter()");
        return new LabTestPresenter(this);
    }
}
