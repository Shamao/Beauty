package com.louise.gank.test.mvc;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.base.BaseActivity;
import com.louise.base.utils.ALogger;
import com.louise.gank.R;
import com.louise.gank.adapter.CommonAdapter;
import com.louise.gank.adapter.IntegerProvider;
import com.louise.gank.adapter.ObjectProvider;
import com.louise.gank.adapter.StringProvider;
import com.louise.gank.bus.TestService;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/gank/test")
public class GankTestAutoWiredActivity extends BaseActivity {

    @Autowired(name = "_name")
    public String name;

    @Autowired(name = "age")
    public long age1;

    @Autowired(name = "age")
    public long age3;


    @Autowired(name = "age")
    public Long age;

    @Autowired(name = "age")
    public long age2;

    @Autowired(name = "gank1/provider")
    public TestService mReceiver;

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
        ALogger.d(mTag, "3", name, age1, age3, age, age2);
        Long age5 = null;
        age5 = getIntent().getLongExtra("age", age5);
        ALogger.d(mTag, "4", name, getIntent().getLongExtra("age", -1), age5);

        ((TextView) findViewById(R.id.text_tv)).setText(name);
        if (mReceiver != null) {
            String data = mReceiver.getData();
            ALogger.d(mTag, "2", data);
        } else {
            String data = ((TestService) ARouter.getInstance().build("/gank1/provider").navigation()).getData();
            ALogger.d(mTag, "1", data);

        }

        List<Object> data = new ArrayList<>();
        data.add("String");
        data.add(0);
        data.add(new Object());

        RecyclerView recyclerView = findViewById(R.id.recycler);
        CommonAdapter adapter = new CommonAdapter(data);
        adapter.register(0, String.class, new StringProvider());
        adapter.register(1, Integer.class, new IntegerProvider());
        adapter.register(2, Object.class, new ObjectProvider());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
