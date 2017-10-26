package princessmakeup.buykee.com.lab;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.view.drawable.PlaceHolderDrawable;

public class LabDrawableActivity extends BaseActivity {

    @BindView(R2.id.lab_iv_1)
    ImageView mLabIv1;
    @BindView(R2.id.ratio_et)
    EditText mRatioEt;


    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_drawable;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        PlaceHolderDrawable placeHolderDrawable1 =
                new PlaceHolderDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.ic_placeholder));
        placeHolderDrawable1.setBounds(0, 0, 600, 1200);
        mLabIv1.setImageDrawable(placeHolderDrawable1);
    }

    @OnClick(R2.id.start_btn)
    void onStartClick(View view) {
        int
    }

}
