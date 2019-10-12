package com.louise.gank.bus;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.louise.base.utils.ALogger;

/**
 * @author lsd
 * @date 2019/10/10.
 */
@Route(path = "/gank1/provider",  name = "111")
public class Receiver implements IProvider {
    @Override
    public void init(Context context) {

    }

    public void receiver(String content) {
        ALogger.d("Arouter-Provicer", content);
    }
}
