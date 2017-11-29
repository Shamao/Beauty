package buykee.com.lab.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;

import java.util.List;

import buykee.com.common.bean.MolColumnBean;
import buykee.com.common.view.holder.ColumnViewHolder;

/**
 * @author lsd
 * @date 2017/11/14.
 */

public class StickyAdapter extends DelegateAdapter.Adapter<ColumnViewHolder> {
    private List<MolColumnBean> mData;

    public StickyAdapter(List<MolColumnBean> data) {
        mData = data;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        StickyLayoutHelper helper = new StickyLayoutHelper();
        helper.setOffset(200);
        return helper;
    }

    @Override
    public ColumnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(ColumnViewHolder.getLayoutId(), parent, false);
        return new ColumnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ColumnViewHolder holder, int position) {
        holder.fillData(new MolColumnBean().withTitle("Sticky", null));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }


}
