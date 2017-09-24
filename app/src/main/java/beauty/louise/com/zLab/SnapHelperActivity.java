package beauty.louise.com.zLab;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.bean.MImageBean;
import beauty.louise.com.view.provider.ImageProvider;
import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;
import princessmakeup.buykee.com.common.base.BaseActivity;

public class SnapHelperActivity extends BaseActivity {

    //data
    private List<MImageBean> mImages;

    @BindView(R.id.linear_snap_recycler)
    RecyclerView mLinearSnapRecyclerView;
    private LinearLayoutManager mLinearSnapLayoutManager;
    private MultiTypeAdapter mLinearSnapAdapter;

    @BindView(R.id.pager_snap_recycler)
    RecyclerView mPagerSnapRecyclerView;
    private LinearLayoutManager mPagerSnapLayoutManager;
    private MultiTypeAdapter mSnapHelperAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.ac_recycler;
    }

    @Override
    public void initData() {
        mImages = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mImages.add(new MImageBean(R.drawable.ph_planet, 2, 1));
        }
        mLinearSnapAdapter = new MultiTypeAdapter(mImages);
        mLinearSnapAdapter.register(MImageBean.class, new ImageProvider());

        mSnapHelperAdapter = new MultiTypeAdapter(mImages);
        mSnapHelperAdapter.register(MImageBean.class, new ImageProvider());

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mLinearSnapRecyclerView.hasFixedSize();
        mLinearSnapLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mLinearSnapRecyclerView.setLayoutManager(mLinearSnapLayoutManager);
        mLinearSnapRecyclerView.setAdapter(mLinearSnapAdapter);
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(mLinearSnapRecyclerView);

        mPagerSnapRecyclerView.hasFixedSize();
        mPagerSnapLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mPagerSnapRecyclerView.setLayoutManager(mPagerSnapLayoutManager);
        mPagerSnapRecyclerView.setAdapter(mSnapHelperAdapter);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(mPagerSnapRecyclerView);

    }
}
