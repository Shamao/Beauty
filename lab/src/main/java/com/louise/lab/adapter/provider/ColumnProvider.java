package com.louise.lab.adapter.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.louise.lab.adapter.holder.ColumnViewHolder;
import com.louise.lab.bean.MColumnBean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @author lsd
 * @date 2018/2/7.
 */

public class ColumnProvider extends ItemViewBinder<MColumnBean, ColumnViewHolder> {

    @NonNull
    @Override
    protected ColumnViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(ColumnViewHolder.getLayoutId(), parent, false);
        return new ColumnViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ColumnViewHolder holder, @NonNull MColumnBean item) {
        holder.fillData(item);
    }
}
