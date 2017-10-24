package beauty.louise.com.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import beauty.louise.com.bean.helper.MFuncList;
import beauty.louise.com.view.holder.FuncViewHolder;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by lsd on 2017/10/23.
 */

public class FuncProvider extends ItemViewBinder<MFuncList, FuncViewHolder> {
    @NonNull
    @Override
    protected FuncViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(FuncViewHolder.getLayoutId(), parent, false);
        return new FuncViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull FuncViewHolder holder, @NonNull MFuncList multiPage) {
        holder.fillData(multiPage.getList());
    }
}
