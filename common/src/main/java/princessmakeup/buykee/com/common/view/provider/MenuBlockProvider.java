package princessmakeup.buykee.com.common.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.drakeet.multitype.ItemViewBinder;
import princessmakeup.buykee.com.common.bean.MStringBean;
import princessmakeup.buykee.com.common.view.holder.MenuBlockViewHolder;

/**
 * @author lsd
 * @date 2017/11/9.
 */

public class MenuBlockProvider extends ItemViewBinder<MStringBean, MenuBlockViewHolder> {
    @NonNull
    @Override
    protected MenuBlockViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(MenuBlockViewHolder.getLayoutId(), parent, false);
        return new MenuBlockViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull MenuBlockViewHolder holder, @NonNull MStringBean item) {
        holder.fillData(item);
    }
}
