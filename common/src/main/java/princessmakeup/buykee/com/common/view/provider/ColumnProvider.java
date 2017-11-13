package princessmakeup.buykee.com.common.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.drakeet.multitype.ItemViewBinder;
import princessmakeup.buykee.com.common.bean.MolColumnBean;
import princessmakeup.buykee.com.common.view.holder.ColumnViewHolder;


/**
 * @author lsd
 * @date 2017/11/9.
 */

public class ColumnProvider extends ItemViewBinder<MolColumnBean, ColumnViewHolder> {
    @NonNull
    @Override
    protected ColumnViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(ColumnViewHolder.getLayoutId(), parent, false);
        return new ColumnViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ColumnViewHolder holder, @NonNull MolColumnBean item) {
        holder.setIsRecyclable(false);
        holder.fillData(item);
    }
}
