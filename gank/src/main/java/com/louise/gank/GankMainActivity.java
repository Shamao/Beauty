package com.louise.gank;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.base.BaseActivity;
import com.louise.base.service.MExecutorService;
import com.louise.base.utils.ALogger;
import com.louise.base.utils.permission.OnRequestPermissionsResultListener;
import com.louise.base.utils.permission.PermissionUtils;
import com.louise.gank.bean.MContact;
import com.louise.gank.bean.MGoods;
import com.louise.gank.view.provider.ContactProvider;
import com.louise.gank.view.provider.GoodsProvider;

import java.util.ArrayList;
import java.util.List;

import cc.hiy.baseui.itemDecoration.CommonLinearItemDecoration;
import cc.hiy.baseui.titlebar.UITitleBar;
import cc.hiy.baseui.titlebar.UITitleDelegate;
import cc.hiy.baseui.titlebar.provider.TitleViewProvider;
import cc.hiy.baseui.utils.DisplayUtils;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author ssss
 */
@Route(path = "/gank/main")
public class GankMainActivity extends BaseActivity implements OnRequestPermissionsResultListener {

    private UITitleBar mTitleBar;

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
        initTitleView();

        mHabitRv = findViewById(R.id.habit_rv);
        mHabitRv.setHasFixedSize(true);
        mHabitRv.setLayoutManager(new LinearLayoutManager(this));
        mHabitRv.addItemDecoration(new CommonLinearItemDecoration(DisplayUtils.dip2px(this, 10)));

        mAdapter = new MultiTypeAdapter(mDatas);
        mAdapter.register(MGoods.class, new GoodsProvider());
        mAdapter.register(MContact.class, new ContactProvider());
        mHabitRv.setAdapter(mAdapter);
    }

    private void initTitleView() {
        mTitleBar = findViewById(R.id.title_bar);
        UITitleDelegate delegate = new UITitleDelegate();
        TitleViewProvider titleViewProvider = delegate.bindTitle(this, mTitleBar, "'习惯广场");
        titleViewProvider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DoubleClickHelper.checkDoubleClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(GankMainActivity.this, "触发了双击", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        delegate.bindLeftBack(this, mTitleBar, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        delegate.bindRightImage(this, mTitleBar, R.drawable.ic_blue, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long a = 11;
                ARouter.getInstance().build("/gank/test").withString("_name", "lsd").withLong("age", a).navigation();
//                ARouter.getInstance().build("/gank/contact/create").withString("name", "lsd").navigation();

//                PermissionUtils.requestPermissions(GankMainActivity.this, 3,
//                        Manifest.permission.CAMERA,
//                        Manifest.permission.RECORD_AUDIO,
//                        Manifest.permission.ACCESS_FINE_LOCATION,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
        });
    }

    @Override
    public void initListener() {
        super.initListener();

        mHabitRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }


            /**
             * @return todo
             */
            public int getScollYDistance() {
                LinearLayoutManager layoutManager = (LinearLayoutManager) mHabitRv.getLayoutManager();
                int position = layoutManager.findFirstVisibleItemPosition();
                View firstVisiableChildView = layoutManager.findViewByPosition(position);
                int itemHeight = firstVisiableChildView.getHeight();
                return (position) * itemHeight - firstVisiableChildView.getTop();
            }


            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //                ALogger.d(mTag, "onScroll = " + getScollYDistance());
                dy = getScollYDistance();
                if (dy < 500) {
                    mTitleBar.setViewAlpha(dy * 1.0f / 500);
                } else {
                    mTitleBar.setViewAlpha(1f);
                }
            }
        });
    }

    @Override
    public void loadData() {
        super.loadData();

        MExecutorService.newThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                final List<MContact> goods = RoomHelper.getInstance().getContactList();
                ALogger.d(mTag, goods.size());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mDatas.addAll(goods);
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        loadData();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        PermissionUtils.isPermissionsDenied(this, permissions);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

}
