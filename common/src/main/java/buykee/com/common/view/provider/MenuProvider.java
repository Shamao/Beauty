package buykee.com.common.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import buykee.com.common.bean.MolStringBean;
import buykee.com.common.view.holder.MenuViewHolder;
import me.drakeet.multitype.ItemViewBinder;

/**
 * @author lsd
 * @date 2017/11/9.
 */

public class MenuProvider extends ItemViewBinder<MolStringBean, MenuViewHolder> {

    public MenuProvider() {
    }

    @NonNull
    @Override
    protected MenuViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(MenuViewHolder.getLayoutId(), parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull final MenuViewHolder holder, @NonNull final MolStringBean item) {
        holder.fillData(item);
    }
}


