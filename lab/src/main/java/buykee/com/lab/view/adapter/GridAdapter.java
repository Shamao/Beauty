package buykee.com.lab.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;

import java.util.List;

import buykee.com.common.bean.MolColumnBean;
import buykee.com.common.view.holder.ColumnViewHolder;

/**
 * @author lsd
 * @date 2017/11/14.
 */

public class GridAdapter extends DelegateAdapter.Adapter<ColumnViewHolder> {
    private List<MolColumnBean> mData;

    public GridAdapter(List<MolColumnBean> data) {
        mData = data;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new GridLayoutHelper(2);
    }

    @Override
    public ColumnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(ColumnViewHolder.getLayoutId(), parent, false);
        return new ColumnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ColumnViewHolder holder, int position) {
        holder.fillData(new MolColumnBean().withTitle("VLayout", null));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 2;
    }


}
