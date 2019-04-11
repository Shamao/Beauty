package cc.hiy.baseui.base;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * recyclerView 基础ViewHolder 添加公共功能
 *
 * @author lsd
 * @date 2019/4/1.
 */
public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {


    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    protected <T extends View> T findViewById(@IdRes int id) {
        return itemView.findViewById(id);
    }
}
