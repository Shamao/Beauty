package com.louise.gank;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.base.BaseActivity;
import com.louise.gank.bus.Receiver;

@Route(path = "/gank/test")
public class GankTestAutoWiredActivity extends BaseActivity {

    @Autowired(name = "name")
    public String name;
    @Autowired(name = "gank1/provider")
    public Receiver mReceiver;

    @Override
    public int getLayoutId() {
        return R.layout.gank_ac_test_auto_wired;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);

        ((TextView) findViewById(R.id.text_tv)).setText(name);
        if (mReceiver != null) {
            mReceiver.receiver(name);
        } else {
            ((Receiver) ARouter.getInstance().build("/gank1/provider").navigation()).receiver(name);
        }
    }
}
