package beauty.louise.com.ui.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.Utils.DisplayUtils;
import beauty.louise.com.Utils.GlideUtils;
import beauty.louise.com.bean.MCoverBean;
import beauty.louise.com.bean.MImageBean;
import beauty.louise.com.bean.base.MultiPage;
import beauty.louise.com.view.UIGradientTopBar;
import beauty.louise.com.view.UIRatioImageView;
import beauty.louise.com.view.provider.BannerProvider;
import beauty.louise.com.view.provider.ImageProvider;
import beauty.louise.com.zLab.LabActivity;
import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.utils.ActivityUtils;


public class MainActivity extends BaseActivity {
    @BindView(R.id.gradient_bar)
    UIGradientTopBar mGradientTopBar;
    @BindView(R.id.cover_iv)
    UIRatioImageView mCoverIv;
    @BindView(R.id.swipe)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    MultiTypeAdapter mAdapter;
    LinearLayoutManager mLayoutManager;

    private List<Object> mData;
    private int mScreenWidth;
    private int mScreenHeight;

    @Override
    public int getLayoutId() {
        return R.layout.ac_main;
    }

    @Override
    public void initData() {
        mScreenWidth = DisplayUtils.getScreenWidth(this);
        mScreenHeight = DisplayUtils.getScreenHeight(this);
        mData = new ArrayList<>();

        MultiPage<MCoverBean> multiPage = new MultiPage<>();
        multiPage.clear();
        multiPage.addItem(
                new MCoverBean("http://static.cosmeapp.com/product/201709/21/09/57/59c31c82d54e4535.jpg", 2,
                               1));
        multiPage.addItem(
                new MCoverBean("http://static.cosmeapp.com/product/201709/15/18/51/59bbb0c372f23674.jpg", mScreenWidth,
                               mScreenWidth / 2));
        multiPage.addItem(
                new MCoverBean("http://static.cosmeapp.com/product/201709/22/10/11/59c47154775f1691.jpg", mScreenWidth,
                               mScreenWidth / 2));

        mData.add(multiPage);
        mAdapter = new MultiTypeAdapter(mData);
        mAdapter.register(MImageBean.class, new ImageProvider());
        mAdapter.register((Class<? extends MultiPage<MCoverBean>>) multiPage.getClass(), new BannerProvider());
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        GlideUtils
                .displayImagePlaceHolder(this, -1,
                                         "http://static.cosmeapp.com/product/201709/22/10/11/59c47154775f1691.jpg")
                .dontAnimate()
                .override(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL,
                          com.bumptech.glide.request.target.Target.SIZE_ORIGINAL)
                .into(mCoverIv);
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
                        mAdapter.notifyDataSetChanged();
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
