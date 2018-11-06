package com.louise.lab;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.lab.adapter.provider.LabAnimDrawableProvider;
import com.louise.lab.bean.MAnimBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.MultiTypeAdapter;

@Route(path = "/lab/view")
public class LabViewActivity extends BaseActivity {

    @BindView(R2.id.lab_tv)
    TextView mLabTv;
    @BindView(R2.id.lab_iv)
    ImageView mLabIv;
    @BindView(R2.id.lab_recycler)
    RecyclerView mRecyclerView;
    MultiTypeAdapter mMultiTypeAdapter;
    private List<Object> mData;


    AnimationDrawable mDrawable;

    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_view;
    }

    @Override
    public void initData() {
        mDrawable =
                (AnimationDrawable) getResources().getDrawable(R.drawable.lab_anim); // todo fix drawable res id name
        mData = new ArrayList<>();
        mData.add(new MAnimBean());

        mMultiTypeAdapter = new MultiTypeAdapter(mData);
        mMultiTypeAdapter.register(MAnimBean.class, new LabAnimDrawableProvider());
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mMultiTypeAdapter);
        mLabIv.setImageDrawable(mDrawable);

        mLabTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawable.isRunning()) {
                    mDrawable.stop();
                    mDrawable.selectDrawable(2);
                    mMultiTypeAdapter.notifyItemChanged(0, 1);
                } else {
                    mDrawable.start();
                    mMultiTypeAdapter.notifyItemChanged(0, 0);
                }
            }
        });

    }
}
