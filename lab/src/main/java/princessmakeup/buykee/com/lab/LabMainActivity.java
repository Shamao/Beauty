package princessmakeup.buykee.com.lab;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;
import me.drakeet.multitype.MultiTypeAdapter;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.bean.MolColumnBean;
import princessmakeup.buykee.com.common.bean.MolLayoutBean;
import princessmakeup.buykee.com.common.bean.MolSeparatorBean;
import princessmakeup.buykee.com.common.bean.MolStringBean;
import princessmakeup.buykee.com.common.listener.OnRecyclerItemClickListener;
import princessmakeup.buykee.com.common.utils.DisplayUtils;
import princessmakeup.buykee.com.common.utils.FontUtils;
import princessmakeup.buykee.com.common.view.UIAdView;
import princessmakeup.buykee.com.common.view.provider.ColumnProvider;
import princessmakeup.buykee.com.common.view.provider.MenuProvider;
import princessmakeup.buykee.com.common.view.provider.SeparatorProvider;
import princessmakeup.buykee.com.lab.view.layoutManager.ScrollSpeedLinearLayoutManager;

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
        MolColumnBean columnBean = new MolColumnBean("专题", "更多", null);
        mData.add(columnBean);
        MolLayoutBean separatorLayoutBean =
                MolLayoutBean.getInstance().withLayoutParams(0, DisplayUtils.dip2px(this, 20))
                        .withBgResId(R.color.default_pink);
        MolSeparatorBean separatorBean = new MolSeparatorBean().withLayout(separatorLayoutBean);
        mData.add(separatorBean);
        mData.add(new MolStringBean("Common专题", "lsd://lsd.design.com/common/common"));
        mData.add(new MolStringBean("transition专题", "http://lsd.design.com/lab/transition"));
        mData.add(new MolStringBean("Canvas专题", "https://lsd.design.com/lab/canvas"));
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
        mData.add(new MolStringBean("待定", ""));
        mAdapter = new MultiTypeAdapter(mData);
        mAdapter.register(MolStringBean.class, new MenuProvider());
        mAdapter.register(MolSeparatorBean.class, new SeparatorProvider());
        mAdapter.register(MolColumnBean.class, new ColumnProvider());
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
                    Uri uri = Uri.parse(schema);
                    ARouter.getInstance().build(uri).navigation();
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
