package com.louise.gank;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.gank.bean.MHabit;
import com.louise.gank.view.provider.HabitProvider;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author ssss
 */
@Route(path = "/gank/main")
public class GankMainActivity extends BaseActivity {

    private RecyclerView mHabitRv;
    private MultiTypeAdapter mAdapter;
    private List<Object> mDatas;

    @Override
    public int getLayoutId() {
        return R.layout.gank_ac_main;
    }

    @Override
    public void initData() {
        mDatas = new ArrayList<>();
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mHabitRv = findViewById(R.id.habit_rv);
        mHabitRv.setHasFixedSize(true);

        mAdapter = new MultiTypeAdapter(mDatas);
        mAdapter.register(MHabit.class, new HabitProvider());
        mHabitRv.setAdapter(mAdapter);
    }

    @Override
    public void loadData() {
        super.loadData();
        mHabitRv.postDelayed(new Runnable() {
            @Override
            public void run() {
                mDatas.add(new MHabit());
                mAdapter.notifyDataSetChanged();
            }
        }, 3000);


    }
}
