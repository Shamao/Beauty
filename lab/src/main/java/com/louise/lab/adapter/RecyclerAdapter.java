package com.louise.lab.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.louise.base.utils.Logger;
import com.louise.base.utils.constance.ConstTag;
import com.louise.lab.adapter.holder.ColumnViewHolder;
import com.louise.lab.bean.MColumnBean;

import java.util.List;

/**
 * @author lsd
 * @date 2018/11/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<ColumnViewHolder> {
    private List<MColumnBean> mData;

    public RecyclerAdapter(List<MColumnBean> data) {
        mData = data;
    }

    @Override
    public ColumnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Logger.d(ConstTag.S_RECYCLERVIEW, "onCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(ColumnViewHolder.getLayoutId(), parent, false);
        return new ColumnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ColumnViewHolder holder, int position) {
        Logger.d(ConstTag.S_RECYCLERVIEW, "onBindViewHolder-2");
        holder.fillData(mData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemRangeChanged(0, 10);
            }
        });
    }

    @Override
    public void onBindViewHolder(ColumnViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        Logger.d(ConstTag.S_RECYCLERVIEW, "onBindViewHolder-3");
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    ///////////////////////////////////////////////////////////////////////////
    // 测试代码
    ///////////////////////////////////////////////////////////////////////////


    @Override
    public void onViewAttachedToWindow(ColumnViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        int adapterPosition = holder.getAdapterPosition();
        int layoutPosition = holder.getLayoutPosition();
        Logger.d(ConstTag.S_RECYCLERVIEW, "adapterPosition = ", adapterPosition, ";layoutPosition =", layoutPosition);

    }
}
