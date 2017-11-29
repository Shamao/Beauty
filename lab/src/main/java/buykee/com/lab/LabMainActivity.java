package buykee.com.lab;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;
import buykee.com.common.base.BaseActivity;
import buykee.com.common.bean.MolColumnBean;
import buykee.com.common.bean.MolLayoutBean;
import buykee.com.common.bean.MolSeparatorBean;
import buykee.com.common.bean.MolStringBean;
import buykee.com.common.bean.MolUserBean;
import buykee.com.common.listener.OnRecyclerItemClickListener;
import buykee.com.common.manager.SchemaManager;
import buykee.com.common.utils.DisplayUtils;
import buykee.com.common.utils.FontUtils;
import buykee.com.common.view.UIAdView;
import buykee.com.common.view.provider.ColumnProvider;
import buykee.com.common.view.provider.MenuProvider;
import buykee.com.common.view.provider.SeparatorProvider;
import buykee.com.common.view.provider.UserProvider;
import buykee.com.lab.view.layoutManager.ScrollSpeedLinearLayoutManager;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author ssss
 */
@Route(path = "/lab/main")
public class LabMainActivity extends BaseActivity {

    @BindView(R2.id.font_tv)
    TextView mFontTv;
    @BindView(R2.id.scroll_btn)
    Button mScrollBtn;
    @BindView(R2.id.ad_container)
    LinearLayout mAdContainer;
    @BindView(R2.id.recycler)
    RecyclerView mRecyclerView;
    MultiTypeAdapter mAdapter;
    ScrollSpeedLinearLayoutManager mLayoutManager;
    List<Object> mData;

    UIAdView mAdView;

    @Override
    public int getLayoutId() {
        return R.layout.lab_activity_main;
    }

    @Override
    public void initData() {
        mData = new ArrayList<>();
        MolColumnBean columnBean = new MolColumnBean().withTitle("用户推荐", null);
        mData.add(columnBean);

        MolUserBean user = new MolUserBean();
        mData.add(user);

        MolLayoutBean separatorLayoutBean =
                MolLayoutBean.getInstance().withLayoutParams(0, DisplayUtils.dip2px(this, 20))
                        .withBgResId(R.color.default_pink);
        MolSeparatorBean separatorBean = new MolSeparatorBean().withLayout(separatorLayoutBean);
        mData.add(separatorBean);

        mData.add(new MolStringBean("Common专题", "lsd://lsd.design.com/common/common"));
        mData.add(new MolStringBean("transition专题", "http://lsd.design.com/lab/transition"));
        mData.add(new MolStringBean("Canvas专题", "https://lsd.design.com/lab/canvas"));
        mData.add(new MolStringBean("VLayout专题", "https://lsd.design.com/lab/vLayout"));
        mData.add(new MolStringBean("Coordinatorlayout", "https://lsd.design.com/lab/coordinator"));
        mData.add(new MolStringBean("待定", ""));
        mData.add(new MolStringBean("待定", ""));
        mData.add(new MolStringBean("待定", ""));
        mData.add(new MolStringBean("待定", ""));
        mData.add(new MolStringBean("待定", ""));
        mData.add(new MolStringBean("待定", ""));
        mData.add(new MolStringBean("待定", ""));
        mData.add(new MolStringBean("待定", ""));
        mData.add(new MolStringBean("待定", ""));
        mData.add(new MolStringBean("待定", ""));
        mAdapter = new MultiTypeAdapter(mData);
        mAdapter.register(MolStringBean.class, new MenuProvider());
        mAdapter.register(MolSeparatorBean.class, new SeparatorProvider());
        mAdapter.register(MolColumnBean.class, new ColumnProvider());
        mAdapter.register(MolUserBean.class, new UserProvider());
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mAdView = new UIAdView(this);
        FontUtils.injectFont(mFontTv);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new ScrollSpeedLinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initListener() {
        super.initListener();
        mRecyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(
                mRecyclerView, new OnRecyclerItemClickListener.OnSimpleItemClickLintener() {
            @Override
            public void onItemClick(View view, int position) {
                super.onItemClick(view, position);
                int viewType = mAdapter.getItemViewType(position);
                if (viewType == mAdapter.getTypePool().firstIndexOf(MolStringBean.class)) {
                    MolStringBean item = (MolStringBean) mData.get(position);
                    String schema = item.getSchema();
                    if (TextUtils.isEmpty(schema)) {
                        Snackbar.make(LabMainActivity.this.getRootView(), "Hahaha", Snackbar.LENGTH_SHORT).show();
                    } else {
                        SchemaManager.getInstance().autoRedirect(schema);
                    }
                }
            }
        }));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick(value = {R2.id.scroll_btn})
    void onScrollClick(View view){
        int position = new Random().nextInt(10);
        mLayoutManager.scrollToPositionWithOffset(position, 0);
    }

    @OnClick(R2.id.ad_btn)
    void onAdClick() {
        if (mAdView.getParent() == null) {
            mAdContainer.addView(mAdView);
        } else {
            mAdContainer.removeView(mAdView);
        }
    }
}
