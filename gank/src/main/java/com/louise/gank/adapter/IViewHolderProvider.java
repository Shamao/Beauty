package com.louise.gank.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * @author zhishui <a href="mailto:liusd@tuya.com">Contact me.</a>
 * @since 2019-10-14
 */
public interface IViewHolderProvider<V extends RecyclerView.ViewHolder, T> {


    public V onCreateViewHolder(ViewGroup parent, LayoutInflater inflater);

    public void onBindViewHolder(V holder, T Data);
}
