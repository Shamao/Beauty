package princessmakeup.buykee.com.beauty.ui;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import princessmakeup.buykee.com.beauty.R;
import princessmakeup.buykee.com.beauty.ui.views.Common.IndicatorDotView;
import princessmakeup.buykee.com.beauty.ui.views.UIDotIndicatorView;

public class ToolActivity extends AppCompatActivity {


    @BindView(R.id.pager)
    ViewPager mViewPager;
    @BindView(R.id.indicator)
    UIDotIndicatorView mDotIndivatorView;

    @BindView(R.id.dot_view)
    IndicatorDotView mIndicatorDotView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool);
        ButterKnife.bind(this);


        MyAdapter myAdapter = new MyAdapter(4);
        mViewPager.setAdapter(myAdapter);
        mDotIndivatorView.setupWithViewPager(mViewPager);
    }

    ValueAnimator valueAnimator;

    @OnClick(R.id.reduce_tv)
    void onReduceClick() {
        //        int width = mIndicatorDotView.getMeasuredWidth();
        //        Logger.d("todo:width", width);
        //        mIndicatorDotView.setResultWidth(width - 10 * 5);
        //        valueAnimator.start();
        int width = mIndicatorDotView.getMeasuredWidth();
        mIndicatorDotView.setResultWidth(width - 10 * 5);
    }

    @OnClick(R.id.add_tv)
    void onAddClick() {
        int width = mIndicatorDotView.getMeasuredWidth();
        mIndicatorDotView.setResultWidth(width + 10 * 5);
    }


    @OnClick(R.id.color_tv)
    void onColorClick() {
        mIndicatorDotView.setColor(Color.BLACK);
    }


    @OnClick(R.id.add_anim_tv)
    void onAddAnimClick() {
        valueAnimator = ValueAnimator.ofFloat(0, 1, 0);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private float lastValue = 0;

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                int width = mIndicatorDotView.getMeasuredWidth();
                mIndicatorDotView.setResultWidth(width + (int) ((value - lastValue) * 100));
                lastValue = value;
            }
        });
        valueAnimator.start();
    }

    @OnClick(R.id.reduce_anim_tv)
    void onReduceAnimClick() {
        valueAnimator = ValueAnimator.ofFloat(1, 0);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private float lastValue = 0;

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                int width = mIndicatorDotView.getMeasuredWidth();
                mIndicatorDotView.setResultWidth(width + (int) ((value - lastValue) * 100));
                lastValue = value;
            }
        });
        valueAnimator.start();
    }

    private class MyAdapter extends PagerAdapter {

        private int size;

        public MyAdapter(int size) {
            this.size = size;
        }

        @Override
        public int getCount() {
            return size;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView coverIv = new ImageView(ToolActivity.this);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                   ViewGroup.LayoutParams.MATCH_PARENT);
            coverIv.setLayoutParams(lp);
            Glide.with(ToolActivity.this).load("http://img3.pplock.com/uploads/2017/02/Robles-326x246.jpg")
                    .into(coverIv);
            container.addView(coverIv);
            return coverIv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
