package princessmakeup.buykee.com.lab;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.utils.ToastUtils;

public class MainActivity extends BaseActivity {

    @BindView(R.id.lab_title_tv)
    TextView mTextTv;

    boolean isCanBackPressed = false;

    @Override
    public int getLayoutId() {
        return R.layout.lab_activity_main;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void onBackPressed() {
        if (isCanBackPressed) {
            isCanBackPressed = true;
        } else {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.lab_title_tv)
    void onLabTextClick(View view) {
        ToastUtils.showShort(this, "点击了");
    }
}
