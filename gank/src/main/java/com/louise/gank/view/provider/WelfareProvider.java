package com.louise.gank.view.provider;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.louise.base.bean.gank.MGankWelfareBean;
import com.louise.base.view.glide.GlideApp;
import com.louise.gank.databinding.GankItemWelfareBinding;
import com.louise.gank.view.holder.WelfareViewHolder;

import me.drakeet.multitype.ItemViewBinder;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * @author lsd
 * @date 2018/3/5.
 */

public class WelfareProvider extends ItemViewBinder<MGankWelfareBean, WelfareViewHolder> {
    GankItemWelfareBinding binding;

    @NonNull
    @Override
    protected WelfareViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        binding = GankItemWelfareBinding.inflate(inflater, parent, false);
        return new WelfareViewHolder(binding.getRoot());
    }

    @Override
    protected void onBindViewHolder(@NonNull WelfareViewHolder holder, @NonNull MGankWelfareBean item) {
        binding.setWelfare(item);
        GlideApp.with(holder.itemView.getContext())
                .load(item.getUrl())
                .transition(withCrossFade())
                .placeholder(new ColorDrawable(Color.WHITE))
                .into(binding.coverIv);
    }
}
