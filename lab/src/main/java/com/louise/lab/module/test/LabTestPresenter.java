package com.louise.lab.module.test;

import com.louise.base.base.mvp.BasePresenter;
import com.louise.base.utils.Logger;
import com.louise.base.utils.constance.ConstTag;

/**
 * @author lsd
 * @date 2018/3/22.
 */

public class LabTestPresenter extends BasePresenter<ILabTestView> {


    public LabTestPresenter(ILabTestView view) {
        super(view);
        Logger.d(ConstTag.S_LIFE_CYCLE, "P---> 初始化");
    }

    @Override
    protected void initData() {
        Logger.d(ConstTag.S_LIFE_CYCLE, "P---> initData");
    }

    @Override
    protected void loadData() {
        Logger.d(ConstTag.S_LIFE_CYCLE, "P---> loadData");
    }

}
