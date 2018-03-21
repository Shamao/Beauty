package com.louise.gank.view.provider;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.louise.base.bean.gank.MGankWelfareBean;
import com.louise.base.view.glide.GlideApp;
import com.louise.gank.R;
import com.louise.gank.databinding.GankItemWelfareBinding;
import com.louise.gank.view.holder.WelfareViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @author lsd
 * @date 2018/3/5.
 */

public class WelfareProvider extends ItemViewBinder<MGankWelfareBean, WelfareViewHolder> {
    GankItemWelfareBinding binding;

    @NonNull
    @Override
    protected WelfareViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gank_item_welfare, parent, false);
        return new WelfareViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull WelfareViewHolder holder, @NonNull MGankWelfareBean item) {
        //        binding.setWelfare(item);
       GankItemWelfareBinding binding =  DataBindingUtil.bind(holder.itemView);
        TextView tv = binding.descTv;
        tv.setText(item.getDesc());

        ImageView iv = binding.coverIv;
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) iv.getLayoutParams();
        lp.dimensionRatio = "2:" + (holder.getAdapterPosition() % +3 + 1);
        iv.setLayoutParams(lp);

        GlideApp.with(holder.itemView.getContext())
                .load(item.getUrl())
                .fitCenter()
                .dontAnimate()
                .into(iv);

        //        binding.dotView.withColor(Color.BLACK)
        //                .withWidth(DisplayUtils.dip2px(holder.itemView.getContext(), 100))
        //                .build();
    }
}
