package com.louise.gank.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.louise.gank.bean.MHabit;
import com.louise.gank.view.holder.HabitViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @author lsd
 * @date 2019/1/10.
 */
public class HabitProvider extends ItemViewBinder<MHabit, HabitViewHolder> {
    @NonNull
    @Override
    protected HabitViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(HabitViewHolder.getLayoutId(), parent, false);
        return new HabitViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull HabitViewHolder holder, @NonNull MHabit item) {
        holder.fillData(item);
    }
}
