package princessmakeup.buykee.com.beauty.ui.splash;

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
import princessmakeup.buykee.com.beauty.Utils.tools.ToolActivity;
import princessmakeup.buykee.com.beauty.base.BaseActivity;
import princessmakeup.buykee.com.common.utils.ActivityUtils;


public class SplashActivity extends BaseActivity {

    @BindView(R.id.logo_iv)
    ImageView mLogoIv;
    @BindView(R.id.count_down_tv)
    TextView mTvCountDown;

    CountDownTimer mCountDownTimer;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        startCountDown();
        translateY();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void loadData() {
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


    /**
     * 开启倒计时
     */
    private void startCountDown() {
        mTvCountDown.setVisibility(View.VISIBLE);
        mCountDownTimer = new CountDownTimer(4000, 1000) {
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
        mCountDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }
}
