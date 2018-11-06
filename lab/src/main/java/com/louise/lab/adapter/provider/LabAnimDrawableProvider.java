package com.louise.lab.adapter.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.louise.lab.adapter.holder.LabAnimDrawableViewHolder;
import com.louise.lab.bean.MAnimBean;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @author lsd
 * @date 2018/11/7.
 */
public class LabAnimDrawableProvider extends ItemViewBinder<MAnimBean, LabAnimDrawableViewHolder> {
    @NonNull
    @Override
    protected LabAnimDrawableViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(LabAnimDrawableViewHolder.getLayoutId(), parent, false);
        return new LabAnimDrawableViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull LabAnimDrawableViewHolder holder, @NonNull MAnimBean item) {

    }

    @Override
    protected void onBindViewHolder(@NonNull LabAnimDrawableViewHolder holder, @NonNull MAnimBean item, @NonNull List<Object> payloads) {
        if (payloads.size() > 0) {
            Object payload = payloads.get(0);
            int value = (int) payload;
            if (value == 0) {
                holder.notifyStart();
            } else {
                holder.notifyStop();
            }
        } else {
            super.onBindViewHolder(holder, item, payloads);
        }
    }
}
