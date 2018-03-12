package com.louise.lab;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.base.bean.BaseResult;
import com.louise.base.bean.gank.MGankWelfareBean;
import com.louise.base.net.RetrofitManager;
import com.louise.base.utils.FileUtils;
import com.louise.base.utils.Logger;
import com.louise.base.utils.constance.ConstTag;
import com.louise.lab.adapter.provider.ColumnProvider;
import com.louise.lab.adapter.provider.SimpleColumnProvider;
import com.louise.lab.bean.MColumnBean;
import com.louise.lab.bean.MMenuBean;
import com.louise.lab.view.AdaptiveDrawable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
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

    @BindView(R2.id.lab_cover_iv)
    ImageView mCoverIv;
    @BindView(R2.id.lab_recycler)
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MultiTypeAdapter mAdapter;
    private List<Object> mData;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.lab_ac_main);
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

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.test_cover);
        mCoverIv.setImageDrawable(new AdaptiveDrawable(bitmap, 10, 1111));
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

    @OnClick(R2.id.lab_cover_iv)
    void onCoverClick() {
        Log.d("111", "111");
        String content1 = FileUtils.readText(this.getResources().openRawResource(R.raw.lab_test_raw));
        String content2 = FileUtils.readFromRaw(this, R.raw.lab_test_raw);
        Logger.d(ConstTag.S_TODO, content1, content2);
    }
}
