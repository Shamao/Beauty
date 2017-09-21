package beauty.louise.com.zLab;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.bean.MImageBean;
import beauty.louise.com.view.provider.ImageProvider;
import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;
import princessmakeup.buykee.com.common.base.BaseActivity;

public class RecyclerActivity extends BaseActivity {

    @BindView(R.id.horizontal_recycler)
    RecyclerView mHorizontalRecyclerView;
    private LinearLayoutManager mHorizontalLayoutManager;
    private MultiTypeAdapter mHorizontalAdapter;
    private List<MImageBean> mImages;

    @BindView(R.id.vertical_recycler)
    RecyclerView mVerticalRecyclerView;
    private LinearLayoutManager mVerticalLayoutManager;
    private MultiTypeAdapter mVerticalAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.ac_recycler;
    }

    @Override
    public void initData() {
        mImages = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mImages.add(new MImageBean(R.drawable.loading, 1, i % 3 + 1));
        }
        mHorizontalAdapter = new MultiTypeAdapter(mImages);
        mHorizontalAdapter.register(MImageBean.class, new ImageProvider());

        mVerticalAdapter = new MultiTypeAdapter(mImages);
        mVerticalAdapter.register(MImageBean.class, new ImageProvider());

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mHorizontalRecyclerView.hasFixedSize();
        mHorizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mHorizontalRecyclerView.setLayoutManager(mHorizontalLayoutManager);
        mHorizontalRecyclerView.setAdapter(mHorizontalAdapter);

        mVerticalRecyclerView.hasFixedSize();
        mVerticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mVerticalRecyclerView.setLayoutManager(mVerticalLayoutManager);
        mVerticalRecyclerView.setAdapter(mVerticalAdapter);

        //LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        //linearSnapHelper.attachToRecyclerView(mLlhRecyclerView);
        //PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        //pagerSnapHelper.attachToRecyclerView(mLlhRecyclerView);
    }
}
