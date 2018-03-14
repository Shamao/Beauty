package com.louise.lab;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/lab/view")
public class LabViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_ac_view);
        View view = findViewById(R.id.big_lab_view);


        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 0.1f, 1.0f, .1f);
        animator.setRepeatCount(10);
        animator.setDuration(5000);
        animator.setRepeatMode(ValueAnimator.RESTART);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationX", -200, 0f, 200f, 0f, -200f);
        animator1.setRepeatCount(10);
        animator1.setDuration(5000);
        animator1.setRepeatMode(ValueAnimator.RESTART);

        AnimatorSet set = new AnimatorSet();
        set.play(animator1).with(animator);
        set.start();
    }
}
