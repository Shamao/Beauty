package com.louise.gank.view.provider;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.louise.base.bean.gank.MGankWelfareBean;
import com.louise.base.view.glide.GlideApp;
import com.louise.gank.R;
import com.louise.gank.databinding.GankItemWelfareBinding;
import com.louise.gank.view.AdaptiveDrawable;
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
        //        holder.setIsRecyclable(false);
        Bitmap bitmap = BitmapFactory.decodeResource(holder.itemView.getContext().getResources(),
                                                     R.drawable.gank_ph_meizi);
        AdaptiveDrawable drawable = new AdaptiveDrawable(bitmap, 0, 0, Color.BLACK);
        drawable.setLevel(50 * holder.getAdapterPosition());
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) binding.coverIv.getLayoutParams();
        lp.dimensionRatio = "2:" + (holder.getAdapterPosition() % +3 + 1);
        binding.coverIv.setLayoutParams(lp);

        GlideApp.with(holder.itemView.getContext())
                .load(item.getUrl())
                .fitCenter()
                .placeholder(drawable)
                .transition(withCrossFade())
                .into(binding.coverIv);
    }
}
