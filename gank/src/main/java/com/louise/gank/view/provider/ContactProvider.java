package com.louise.gank.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.louise.gank.bean.MContact;
import com.louise.gank.view.holder.JsonViewHolder;

import me.drakeet.multitype.ItemViewBinder;


/**
 * @author lsd
 * @date 2019/1/10.
 */
public class ContactProvider extends ItemViewBinder<MContact, JsonViewHolder> {
    @NonNull
    @Override
    protected JsonViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(JsonViewHolder.getLayoutId(), parent, false);
        return new JsonViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull JsonViewHolder holder, @NonNull MContact item) {
        holder.fillData(new Gson().toJson(item));
    }
}
