package com.louise.gank.view.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.google.android.flexbox.FlexboxLayout;
import cc.hiy.baseui.utils.DisplayUtils;
import com.louise.gank.view.holder.MainAdViewHolder;

import cc.hiy.baseui.flexbox.FlexBoxAdapter;

/**
 * @author lsd
 * @date 2019/5/11.
 */
public class MainAdAdapter extends FlexBoxAdapter<MainAdViewHolder> {


    @Override
    public MainAdViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = new View(parent.getContext());
        int size = DisplayUtils.dip2px(parent.getContext(), 40);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(size,size);
        view.setLayoutParams(lp);
        return new MainAdViewHolder(view);
    }

    @Override
    public void onLayoutView(View itemView, int spanCount, int position) {
        if (position == 5) {
            FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) itemView.getLayoutParams();
            lp.setWrapBefore(true);
            itemView.setLayoutParams(lp);
        }
    }

    @Override
    public void onBindViewHolder(MainAdViewHolder holder, int position) {

    }

    @Override
    public int getCount() {
        return 10;
    }
}
