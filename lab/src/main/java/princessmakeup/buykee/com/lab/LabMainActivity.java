package princessmakeup.buykee.com.lab;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.drakeet.multitype.MultiTypeAdapter;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.bean.MolStringBean;
import princessmakeup.buykee.com.common.listener.OnRecyclerItemClickListener;
import princessmakeup.buykee.com.common.utils.StringUtils;
import princessmakeup.buykee.com.common.view.provider.MenuProvider;
import princessmakeup.buykee.com.lab.view.layoutManager.ScrollSpeedLinearLayoutManager;


/**
 * @author ssss
 */
public class LabMainActivity extends BaseActivity {
    @BindView(R2.id.position_et)
    EditText mPositionEt;
    @BindView(R2.id.scroll_btn)
    Button mScrollBtn;
    @BindView(R2.id.recycler)
    RecyclerView mRecyclerView;
    MultiTypeAdapter mAdapter;
    ScrollSpeedLinearLayoutManager mLayoutManager;
    List<MolStringBean> mData;

    @Override
    public int getLayoutId() {
        return R.layout.lab_activity_main;
    }

    @Override
    public void initData() {
        mData = new ArrayList<>();
        mData.add(new MolStringBean("Common专题", "lsd://lsd.design.com/common/common"));
        mData.add(new MolStringBean("transition专题", "http://lsd.design.com/lab/transition"));
        mData.add(new MolStringBean("Canvas专题", "https://lsd.design.com/lab/canvas"));
        mAdapter = new MultiTypeAdapter(mData);
        mAdapter.register(MolStringBean.class, new MenuProvider());
    }

    @Override
    public void initView(Bundle savedInstanceState) {
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
                String schema = mData.get(position).getSchema();
                Uri uri = Uri.parse(schema);
                ARouter.getInstance().build(uri).navigation();
            }
        }));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick(value = {R2.id.scroll_btn})
    void onScrollClick(View view){
        String content = mPositionEt.getText().toString().trim();
        int position = StringUtils.toInt(content, 0);
        mLayoutManager.scrollToPositionWithOffset(position, 0);
    }
}
