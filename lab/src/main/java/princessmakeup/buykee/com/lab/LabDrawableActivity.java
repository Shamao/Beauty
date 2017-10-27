package princessmakeup.buykee.com.lab;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.view.drawable.PlaceHolderDrawable;

public class LabDrawableActivity extends BaseActivity {

    @BindView(R2.id.lab_iv_1)
    ImageView mLabIv1;
    @BindView(R2.id.ratio_tv)
    TextView mRatioTv;
    PlaceHolderDrawable placeHolderDrawable;

    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_drawable;
    }

    @Override
    public void initData() {
        placeHolderDrawable = new PlaceHolderDrawable(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_placeholder));
        placeHolderDrawable.setBounds(0,0,300,300);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mLabIv1.setImageDrawable(placeHolderDrawable);
    }

    @OnClick(R2.id.start_btn)
    void onStartClick(View view) {
        ViewGroup.LayoutParams lp = mLabIv1.getLayoutParams();
        lp.height = lp.width * new Random().nextInt(10) + 1;
        mLabIv1.setLayoutParams(lp);
    }

}
