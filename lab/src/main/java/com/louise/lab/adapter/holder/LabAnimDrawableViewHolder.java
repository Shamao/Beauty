package com.louise.lab.adapter.holder;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.louise.lab.R;

/**
 * @author lsd
 * @date 2018/11/7.
 */
public class LabAnimDrawableViewHolder extends RecyclerView.ViewHolder {
    public static int getLayoutId() {
        return R.layout.lab_item_animate_drawable;
    }

    private ImageView mLabIv;
    private AnimationDrawable mAnimationDrawable;

    public LabAnimDrawableViewHolder(View itemView) {
        super(itemView);
        mLabIv = itemView.findViewById(R.id.lab_iv);
        mAnimationDrawable = (AnimationDrawable) itemView.getResources().getDrawable(R.drawable.lab_anim);
        mLabIv.setImageDrawable(mAnimationDrawable);
    }

    public void notifyStart() {
        mAnimationDrawable.start();
    }

    public void notifyStop() {
        mAnimationDrawable.stop();
        mAnimationDrawable.selectDrawable(2);
    }
}
