package com.louise.lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lsd
 * @date 2018/2/8.
 */
@Route(path = "/lab/guide")
public class LabGuideActivity extends BaseActivity {
    @BindView(R2.id.lab_btn)
    Button mLabBtn;


    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_guide;
    }

    @Override
    public View getLayoutView() {
        return null;
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.lab_btn)
    void onLabBtnClick(View view) {
        ARouter.getInstance().build("/lab/main").navigation();
    }
}
