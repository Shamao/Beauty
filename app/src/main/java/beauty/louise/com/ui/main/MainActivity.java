package beauty.louise.com.ui.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.bean.MImageBean;
import beauty.louise.com.view.UIGradientTopBar;
import beauty.louise.com.view.provider.CoverProvider;
import beauty.louise.com.zLab.LabActivity;
import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.utils.ActivityUtils;


public class MainActivity extends BaseActivity {
    @BindView(R.id.gradient_bar)
    UIGradientTopBar mGradientTopBar;

    @BindView(R.id.swipe)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    MultiTypeAdapter mAdapter;
    LinearLayoutManager mLayoutManager;

    private List<Object> mData;

    @Override
    public int getLayoutId() {
        return R.layout.ac_main;
    }

    @Override
    public void initData() {
        mData = new ArrayList<>();
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
                mSwipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 800);
            }
        });

        mGradientTopBar.setOnTopBarClickListener(new UIGradientTopBar.OnTopBarClickListener() {
            @Override
            public void onLeftClick(View view) {

            }

            @Override
            public void onRightClick(View view) {
                ActivityUtils.startActivity(MainActivity.this, LabActivity.class);
            }
        });
    }


}
