package com.louise.lab.adapter.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.louise.lab.adapter.holder.SimpleMenuViewHolder;
import com.louise.lab.bean.MMenuBean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @author lsd
 * @date 2018/2/7.
 */

public class SimpleColumnProvider extends ItemViewBinder<MMenuBean, SimpleMenuViewHolder> {

    @NonNull
    @Override
    protected SimpleMenuViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(SimpleMenuViewHolder.getLayoutId(), parent, false);
        return new SimpleMenuViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull SimpleMenuViewHolder holder, @NonNull MMenuBean item) {
        holder.fillData(item);
    }
}
