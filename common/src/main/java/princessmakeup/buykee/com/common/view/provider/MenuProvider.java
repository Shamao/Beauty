package princessmakeup.buykee.com.common.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.drakeet.multitype.ItemViewBinder;
import princessmakeup.buykee.com.common.bean.MStringBean;
import princessmakeup.buykee.com.common.view.holder.MenuViewHolder;

/**
 * @author lsd
 * @date 2017/11/9.
 */

public class MenuProvider extends ItemViewBinder<MStringBean, MenuViewHolder> {
    @NonNull
    @Override
    protected MenuViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(MenuViewHolder.getLayoutId(), parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull MenuViewHolder holder, @NonNull MStringBean item) {
        holder.fillData(item);
    }
}
