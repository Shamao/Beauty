package com.louise.gank.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.louise.gank.bean.MGoods;
import com.louise.gank.view.holder.GoodsViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @author lsd
 * @date 2019/1/10.
 */
public class GoodsProvider extends ItemViewBinder<MGoods, GoodsViewHolder> {
    @NonNull
    @Override
    protected GoodsViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(GoodsViewHolder.getLayoutId(), parent, false);
        return new GoodsViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull GoodsViewHolder holder, @NonNull MGoods item) {
        holder.fillData(item);
    }
}
