package beauty.louise.com.ui.splash;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.louise.base.base.BaseActivity;

import beauty.louise.com.R;
import butterknife.BindView;


/**
 * @author ssss
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView mTitleTv;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.ac_splash);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mTitleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimator();
            }
        });
    }

    private void startAnimator() {
        int centerX = (mTitleTv.getLeft() + mTitleTv.getRight()) / 2;
        int centerY = (mTitleTv.getTop() + mTitleTv.getBottom()) / 2;

        // 获取扩散的半径
        float finalRadius =
                (float) Math.hypot((double) mTitleTv.getMeasuredWidth() / 2, (double) mTitleTv.getHeight() / 2);
        // 定义揭露动画
        Animator mCircularReveal = ViewAnimationUtils.createCircularReveal(
                mTitleTv, mTitleTv.getWidth() / 2, mTitleTv.getHeight() / 2, 10, 1000);
        // 设置动画持续时间，并开始动画
        mCircularReveal.setDuration(2000).start();
        mCircularReveal.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ARouter.getInstance().build("/main/main").navigation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
