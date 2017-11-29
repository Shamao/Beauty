package buykee.com.lab.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;

import java.util.List;

import buykee.com.common.bean.MolColumnBean;
import buykee.com.common.bean.MolStringBean;
import buykee.com.common.view.holder.MenuBlockViewHolder;

/**
 * @author lsd
 * @date 2017/11/14.
 */

public class ScrollFixAdapter extends DelegateAdapter.Adapter<MenuBlockViewHolder> {
    private List<MolColumnBean> mData;

    public ScrollFixAdapter(List<MolColumnBean> data) {
        mData = data;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        ScrollFixLayoutHelper helper = new ScrollFixLayoutHelper(FixLayoutHelper.TOP_RIGHT, 10, 10);
        helper.setShowType(ScrollFixLayoutHelper.SHOW_ON_ENTER);
        return helper;
    }

    @Override
    public MenuBlockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(MenuBlockViewHolder.getLayoutId(), parent, false);
        return new MenuBlockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuBlockViewHolder holder, int position) {
        holder.fillData(new MolStringBean("block", null));
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
