package buykee.com.lab.view.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.FloatLayoutHelper;

import java.util.List;

import buykee.com.common.bean.MolColumnBean;
import buykee.com.common.bean.MolStringBean;
import buykee.com.common.view.holder.MenuBlockViewHolder;

/**
 * @author lsd
 * @date 2017/11/14.
 */

public class FloatAdapter extends DelegateAdapter.Adapter<MenuBlockViewHolder> {
    private List<MolColumnBean> mData;

    public FloatAdapter(List<MolColumnBean> data) {
        mData = data;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        FloatLayoutHelper helper = new FloatLayoutHelper();
        helper.setAlignType(FixLayoutHelper.BOTTOM_LEFT);
        helper.setBgColor(Color.RED);
        return helper;
    }

    @Override
    public MenuBlockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(MenuBlockViewHolder.getLayoutId(), parent, false);
        return new MenuBlockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuBlockViewHolder holder, int position) {
        holder.fillData(new MolStringBean("Float", null));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 2;
    }


}
