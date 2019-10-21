package com.louise.gank.bus;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author lsd
 * @date 2019/10/10.
 */
@Route(path = "/gank1/provider", name = "111")
public class TestService implements IProvider {

    @Autowired(name = "/gank1/dao")
    TestDao mTestDao;


    @Override
    public void init(Context context) {
        ARouter.getInstance().inject(this);

    }

    public String getData() {
        return "来自服务" + mTestDao.getData();
    }
}
