package com.louise.gank.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * @author zhishui <a href="mailto:liusd@tuya.com">Contact me.</a>
 * @since 2019-10-14
 */
public class StringProvider implements IViewHolderProvider<StringViewHolder, String> {


    @Override
    public StringViewHolder onCreateViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new StringViewHolder(inflater.inflate(StringViewHolder.getlayoutId(), parent, false));
    }

    @Override
    public void onBindViewHolder(StringViewHolder holder, String value) {
        holder.fillData(value);
    }
}
