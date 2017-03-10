package princessmakeup.buykee.com.beauty.ui.splash.v.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import princessmakeup.buykee.com.beauty.R;
import princessmakeup.buykee.com.beauty.Utils.DisplayUtils;
import princessmakeup.buykee.com.beauty.base.BaseActivity;
import princessmakeup.buykee.com.beauty.ui.ToolActivity;
import princessmakeup.buykee.com.beauty.ui.main.MainActivity;
import princessmakeup.buykee.com.beauty.ui.splash.p.SplashPresent;
import princessmakeup.buykee.com.common.utils.ActivityUtils;
import princessmakeup.buykee.com.common.utils.Logger;
import princessmakeup.buykee.com.common.utils.constant.ConstTag;


public class SplashActivity extends BaseActivity<SplashPresent> {

    @BindView(R.id.logo_iv)
    ImageView mLogoIv;
    @BindView(R.id.count_down_tv)
    TextView mTvCountDown;


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

        startCountDown();
        translateY();
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
        ValueAnimator animator = ValueAnimator.ofFloat(1, 1.5f);
        animator.setDuration(2000);
        animator.setStartDelay(1000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();

        final int screenHeight = DisplayUtils.getScreenHeight(SplashActivity.this);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {//1-1.3
                float value = (float) animation.getAnimatedValue();
                mLogoIv.setTranslationY(screenHeight * (1 - value));
            }
        });
    }

    @Override
    public void onSuccess(int category, Object object) {


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
                ActivityUtils.startActivity(SplashActivity.this, ToolActivity.class);
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
