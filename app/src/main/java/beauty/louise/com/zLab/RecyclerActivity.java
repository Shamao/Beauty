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

    @BindView(R.id.llh_recycler)
    RecyclerView mLlhRecyclerView;
    private LinearLayoutManager mLlhLayoutManager;
    private MultiTypeAdapter mLlhAdapter;
    private List<MImageBean> mImages;

    @Override
    public int getLayoutId() {
        return R.layout.ac_recycler;
    }

    @Override
    public void initData() {
        mImages = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mImages.add(new MImageBean());
        }
        mLlhAdapter = new MultiTypeAdapter(mImages);
        mLlhAdapter.register(MImageBean.class, new ImageProvider());

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mLlhRecyclerView.hasFixedSize();
        mLlhLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mLlhRecyclerView.setLayoutManager(mLlhLayoutManager);
        mLlhRecyclerView.setAdapter(mLlhAdapter);
        //        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        //        linearSnapHelper.attachToRecyclerView(mLlhRecyclerView);
        //        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        //        pagerSnapHelper.attachToRecyclerView(mLlhRecyclerView);
    }
}
