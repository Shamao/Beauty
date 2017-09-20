package beauty.louise.com.zLab;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import beauty.louise.com.R;
import butterknife.BindView;
import butterknife.OnClick;
import me.drakeet.multitype.MultiTypeAdapter;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.utils.ActivityUtils;

public class LabActivity extends BaseActivity {

    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    MultiTypeAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.a_lab;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @OnClick(R.id.recycler_module_tv)
    void onRecyclerModuletClick(View view) {
        ActivityUtils.startActivity(this, RecyclerActivity.class);
    }
}
