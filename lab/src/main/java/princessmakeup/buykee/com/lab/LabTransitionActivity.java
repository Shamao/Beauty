package princessmakeup.buykee.com.lab;

import android.os.Bundle;
import android.support.transition.AutoTransition;
import android.support.transition.Slide;
import android.support.transition.TransitionManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.bean.MolStringBean;
import princessmakeup.buykee.com.common.listener.OnRecyclerItemClickListener;
import princessmakeup.buykee.com.common.utils.DisplayUtils;
import princessmakeup.buykee.com.common.view.itemdecoration.LinearDecoration;
import princessmakeup.buykee.com.common.view.provider.MenuBlockProvider;

/**
 * @author ssss
 */
@Route(path = "/lab/transition")
public class LabTransitionActivity extends BaseActivity {


    @BindView(R2.id.lab_recycler)
    RecyclerView mRecyclerView;
    MultiTypeAdapter mAdapter;
    List<MolStringBean> mData;
    LinearLayoutManager mLayoutManager;

    @BindView(R2.id.lab_content)
    LinearLayout mContentView;
    @BindView(R2.id.lab_text_tv)
    TextView mTextTv;
    @BindView(R2.id.lab_start_btn)
    Button mStartBtn;
    AutoTransition mAutoTransition;

    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_transition;
    }

    @Override
    public void initData() {
        mData = new ArrayList<>();
        mData.add(new MolStringBean("Common", null));
        mData.add(new MolStringBean("Common", null));
        mData.add(new MolStringBean("Common", null));
        mData.add(new MolStringBean("Common", null));
        mData.add(new MolStringBean("Common", null));
        mData.add(new MolStringBean("Common", null));
        mData.add(new MolStringBean("Common", null));
        mAdapter = new MultiTypeAdapter(mData);
        mAdapter.register(MolStringBean.class, new MenuBlockProvider());
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        mAutoTransition = new AutoTransition();
        mRecyclerView.hasFixedSize();
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView
                .addItemDecoration(new LinearDecoration(DisplayUtils.dip2px(this, 10), LinearLayout.HORIZONTAL, true));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initListener() {
        super.initListener();
        mRecyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(
                mRecyclerView, new OnRecyclerItemClickListener.OnSimpleItemClickLintener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == 0) {
                    autoTransition();
                } else {
                    slideTransition();
                }
            }
        }));
    }

    private void autoTransition() {
        TransitionManager.beginDelayedTransition(mContentView, mAutoTransition);
        if (mTextTv.getVisibility() == View.VISIBLE) {
            mTextTv.setVisibility(View.GONE);
        } else {
            mTextTv.setVisibility(View.VISIBLE);
        }
    }

    private void slideTransition() {
        TransitionManager.beginDelayedTransition(mContentView, new Slide(Gravity.TOP));
        if (mTextTv.getVisibility() == View.VISIBLE) {
            mTextTv.setVisibility(View.INVISIBLE);
        } else {
            mTextTv.setVisibility(View.VISIBLE);
        }
    }
}
