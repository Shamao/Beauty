package com.louise.lab;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.base.bean.BaseResult;
import com.louise.base.bean.gank.MGankWelfareBean;
import com.louise.base.net.RetrofitManager;
import com.louise.base.utils.Logger;
import com.louise.lab.adapter.provider.ColumnProvider;
import com.louise.lab.adapter.provider.SimpleColumnProvider;
import com.louise.lab.bean.MColumnBean;
import com.louise.lab.bean.MMenuBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author ssss
 */
@Route(path = "/lab/main")
public class LabMainActivity extends BaseActivity {

    @BindView(R2.id.lab_recycler)
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MultiTypeAdapter mAdapter;
    private List<Object> mData;

    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_main;
    }

    @Override
    public void initData() {
        mData = new ArrayList<>();
        mData.add(new MColumnBean("引导页"));
        mData.add(new MMenuBean("大本营", "/main/main"));
        mData.add(new MMenuBean("视觉差引导页", "/lab/guide"));
        mData.add(new MMenuBean("自定义View测试", "/lab/view"));
        mAdapter = new MultiTypeAdapter(mData);
        mAdapter.register(MColumnBean.class, new ColumnProvider());
        mAdapter.register(MMenuBean.class, new SimpleColumnProvider());
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    void onTestClick() {
        RetrofitManager.getInstance().createGankApiservice().getGankWelfare("福利", 10, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResult<List<MGankWelfareBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Logger.d("", "");
                    }

                    @Override
                    public void onNext(BaseResult<List<MGankWelfareBean>> listBaseResult) {
                        Logger.d("", "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("", "");
                    }

                    @Override
                    public void onComplete() {
                        Logger.d("", "");
                    }
                });
    }
}
