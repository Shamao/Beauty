package princessmakeup.buykee.com.beauty.ui.splash.v.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import princessmakeup.buykee.com.beauty.R;
import princessmakeup.buykee.com.beauty.base.BaseActivity;
import princessmakeup.buykee.com.beauty.bean.index.AdBean;
import princessmakeup.buykee.com.beauty.ui.main.MainActivity;
import princessmakeup.buykee.com.beauty.ui.splash.p.SplashPresent;
import princessmakeup.buykee.com.common.utils.ActivityUtils;
import princessmakeup.buykee.com.common.utils.DeviceUtils;
import princessmakeup.buykee.com.common.utils.Logger;
import princessmakeup.buykee.com.common.utils.constant.ConstTag;


public class SplashActivity extends BaseActivity<SplashPresent> {

    @BindView(R.id.iv_logo)
    ImageView mLogoIv;
    @BindView(R.id.tv_count_down)
    TextView mTvCountDown;

    AdBean mAdBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initData() {
    }


    @Override
    public void initView(Bundle savedInstanceState) {
        mPresenter = new SplashPresent(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void loadData() {
        mPresenter.loadData(0, null);
    }


    @Override
    public void initListener() {
        super.initListener();
    }

    private void translateY() {
        ValueAnimator animator = ValueAnimator.ofFloat(1, 1.3f);
        animator.setDuration(1000);
        animator.start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mLogoIv.setTranslationY(value * DeviceUtils.getScreenHeight(SplashActivity.this) * (1 - value));
            }
        });
    }

    @Override
    public void onSuccess(int category, Object object) {
        mAdBean = (AdBean) object;
        if ("1".equals(mAdBean.getHasAd())) {
            Glide.with(this).load(mAdBean.getImgUrl()).crossFade().into(mLogoIv);
        } else {
            startCountDown();
        }
        translateY();
    }

    /**
     * 开启倒计时
     */
    private void startCountDown() {
        mTvCountDown.setVisibility(View.VISIBLE);
        CountDownTimer countDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTvCountDown.setText(getString(R.string.count_down, millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                ActivityUtils.startActivity(SplashActivity.this, MainActivity.class);
                finish();
            }
        };
        countDownTimer.start();
    }

    @Override
    public void onFailed(Object object) {
        Logger.d(ConstTag.todo, "fail");
    }
}
