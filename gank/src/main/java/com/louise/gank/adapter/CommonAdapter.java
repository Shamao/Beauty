package com.louise.gank.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhishui <a href="mailto:liusd@tuya.com">Contact me.</a>
 * @since 2019-10-14
 */
public class CommonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Map<Integer, IViewHolderProvider> mTypePool = new HashMap<>();
    private Map<Class, Integer> mClassPool = new HashMap<>();

    public List<?> mData;

    public CommonAdapter(List<?> data) {
        mData = data;
    }

    public void register(int viewType, Class clz, IViewHolderProvider iViewHolderProvider) {
        mTypePool.put(viewType, iViewHolderProvider);
        mClassPool.put(clz, viewType);
    }

    public void unRegister(int viewType, Class clz) {
        mTypePool.remove(viewType);
        mClassPool.remove(clz);
    }

    @Override
    public int getItemViewType(int position) {
        return mClassPool.get(mData.get(position).getClass());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        IViewHolderProvider provider = mTypePool.get(viewType);

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return provider.onCreateViewHolder(parent, inflater);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        IViewHolderProvider provider = mTypePool.get(getItemViewType(position));
        provider.onBindViewHolder(holder, mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
