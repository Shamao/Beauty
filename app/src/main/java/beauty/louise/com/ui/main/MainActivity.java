package beauty.louise.com.ui.main;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import beauty.louise.com.BuildConfig;
import beauty.louise.com.R;
import beauty.louise.com.bean.MCoverBean;
import beauty.louise.com.bean.MFuncBean;
import beauty.louise.com.bean.MImageBean;
import beauty.louise.com.bean.MTagBean;
import beauty.louise.com.bean.helper.MCoverList;
import beauty.louise.com.bean.helper.MFuncList;
import beauty.louise.com.bean.helper.MTagList;
import beauty.louise.com.view.UIGradientTopBar;
import beauty.louise.com.view.provider.BannerProvider;
import beauty.louise.com.view.provider.CoverProvider;
import beauty.louise.com.view.provider.FuncProvider;
import beauty.louise.com.view.provider.ImageProvider;
import beauty.louise.com.view.provider.TagProvider;
import beauty.louise.com.zLab.LabActivity;
import butterknife.BindView;
import butterknife.OnClick;
import me.drakeet.multitype.MultiTypeAdapter;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.utils.ActivityUtils;
import princessmakeup.buykee.com.common.utils.Logger;
import pub.devrel.easypermissions.EasyPermissions;


public class MainActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {
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

        List<MCoverBean> coverList = new ArrayList<>();
        coverList.add(new MCoverBean("http://static.cosmeapp.com/product/201709/21/09/57/59c31c82d54e4535.jpg", 2, 1));
        coverList.add(new MCoverBean("http://static.cosmeapp.com/product/201709/15/18/51/59bbb0c372f23674.jpg", 2, 1));
        coverList.add(new MCoverBean("http://static.cosmeapp.com/product/201709/22/10/11/59c47154775f1691.jpg", 2, 1));
        mData.add(MCoverList.newInstance(coverList));

        List<MFuncBean> funcList = new ArrayList<>();
        funcList.add(new MFuncBean());
        funcList.add(new MFuncBean());
        funcList.add(new MFuncBean());
        funcList.add(new MFuncBean());
        funcList.add(new MFuncBean());
        funcList.add(new MFuncBean());
        funcList.add(new MFuncBean());
        funcList.add(new MFuncBean());
        mData.add(MFuncList.newInstance(funcList));

        List<MTagBean> tagList = new ArrayList<>();
        tagList.add(new MTagBean("小小屋"));
        tagList.add(new MTagBean("今日话题"));
        tagList.add(new MTagBean("小小屋"));
        tagList.add(new MTagBean("今日话题"));
        tagList.add(new MTagBean("小小屋"));
        tagList.add(new MTagBean("今日话题"));
        tagList.add(new MTagBean("小小屋"));
        tagList.add(new MTagBean("今日话题"));
        tagList.add(new MTagBean("小小屋"));
        mData.add(MTagList.newInstance(tagList));

        mData.add(new MImageBean("https://img.alicdn.com/tfs/TB1seiEcGagSKJjy0FhXXcrbFXa-740-240.jpg", 74, 24));
        mData.add(new MImageBean("https://img.alicdn.com/tfs/TB1b92vlgoQMeJjy0FpXXcTxpXa-740-240.png", 74, 24));
        mData.add(new MImageBean("https://img.alicdn.com/tfs/TB1seiEcGagSKJjy0FhXXcrbFXa-740-240.jpg", 74, 24));
        mData.add(new MImageBean("https://img.alicdn.com/tfs/TB1b92vlgoQMeJjy0FpXXcTxpXa-740-240.png", 74, 24));
        mData.add(new MImageBean("https://img.alicdn.com/tfs/TB1seiEcGagSKJjy0FhXXcrbFXa-740-240.jpg", 74, 24));
        mData.add(new MImageBean("https://img.alicdn.com/tfs/TB1b92vlgoQMeJjy0FpXXcTxpXa-740-240.png", 74, 24));

        mAdapter = new MultiTypeAdapter(mData);
        mAdapter.register(MCoverList.class, new BannerProvider());
        mAdapter.register(MFuncList.class, new FuncProvider());
        mAdapter.register(MTagList.class, new TagProvider());
        mAdapter.register(MCoverBean.class, new CoverProvider());
        mAdapter.register(MImageBean.class, new ImageProvider());
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
                if (!BuildConfig.isBuildModule) {
                    ActivityUtils.startActivity(MainActivity.this, Intent.ACTION_VIEW, "lab://main", 0);
                } else {
                    ActivityUtils.startActivity(MainActivity.this, LabActivity.class);
                }
            }
        });
    }

    @OnClick(R.id.permission_tv)
    void onPermissionClick(View view) {
        EasyPermissions.requestPermissions(this, null, 1, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                           Manifest.permission.CAMERA);
    }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Logger.d(mTag, "onPermissionsGranted", requestCode, perms);
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Logger.d(mTag, "onPermissionsGranted", requestCode, perms);

    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        return super.shouldShowRequestPermissionRationale(permission);
    }
}
