package beauty.louise.com.ui.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.base.BaseActivity;
import beauty.louise.com.bean.MImageBean;
import beauty.louise.com.view.provider.CoverProvider;
import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;


public class MainActivity extends BaseActivity {
    @BindView(R.id.swipe)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    MultiTypeAdapter mAdapter;
    LinearLayoutManager mLayoutManager;

    private List<Object> mData;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        mData = new ArrayList<>();
        mData.add(new MImageBean());
        mData.add(new MImageBean());
        mData.add(new MImageBean());
        mData.add(new MImageBean());
        mData.add(new MImageBean());
        mAdapter = new MultiTypeAdapter(mData);
        mAdapter.register(MImageBean.class, new CoverProvider());

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void initListener() {
        super.initListener();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
