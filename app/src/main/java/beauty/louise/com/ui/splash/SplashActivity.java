package beauty.louise.com.ui.splash;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import beauty.louise.com.R;
import beauty.louise.com.Utils.DisplayUtils;
import beauty.louise.com.ui.main.MainActivity;
import butterknife.BindView;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.utils.ActivityUtils;
import princessmakeup.buykee.com.common.utils.Logger;


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
        //        startCountDown();
        //        translateY();
    }

    @Override
    public void loadData() {
    }

    @Override
    public void initListener() {
        super.initListener();
        mLogoIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d(mTag, "onClick");
                startCountDown();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
                ActivityUtils.startActivity(SplashActivity.this, MainActivity.class);
                finish();
            }
        };
        mCountDownTimer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }
}
