package com.louise.gank.bus;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author lsd
 * @date 2019/10/10.
 */
@Route(path = "/gank1/dao",  name = "111")
public class TestDao implements IProvider {
    @Override
    public void init(Context context) {
    }

    public String getData() {
        return "来自数据库";
    }
}
