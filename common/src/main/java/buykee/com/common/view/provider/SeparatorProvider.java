package buykee.com.common.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import buykee.com.common.bean.MolSeparatorBean;
import me.drakeet.multitype.ItemViewBinder;
import buykee.com.common.R;
import buykee.com.common.view.holder.SeparatorViewHolder;

/**
 * @author lsd
 * @date 2017/11/13.
 */

public class SeparatorProvider extends ItemViewBinder<MolSeparatorBean, SeparatorViewHolder> {
    @NonNull
    @Override
    protected SeparatorViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_seperator, parent, false);
        return new SeparatorViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull SeparatorViewHolder holder, @NonNull MolSeparatorBean item) {
        holder.fillLayout(item.getLayoutBean());
    }
}
