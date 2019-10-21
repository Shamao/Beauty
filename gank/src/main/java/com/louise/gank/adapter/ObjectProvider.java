package com.louise.gank.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * @author zhishui <a href="mailto:liusd@tuya.com">Contact me.</a>
 * @since 2019-10-14
 */
public class ObjectProvider implements IViewHolderProvider<StringViewHolder, Object> {


    @Override
    public StringViewHolder onCreateViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new StringViewHolder(inflater.inflate(StringViewHolder.getlayoutId(), parent, false));
    }

    @Override
    public void onBindViewHolder(StringViewHolder holder, Object object) {
        holder.fillData(object.getClass().getSimpleName());
    }
}
