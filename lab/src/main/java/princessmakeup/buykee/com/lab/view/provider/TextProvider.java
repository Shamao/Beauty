package princessmakeup.buykee.com.lab.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.drakeet.multitype.ItemViewBinder;
import princessmakeup.buykee.com.lab.view.holder.TextViewHolder;

/**
 * Created by lsd on 2017/10/20.
 */

public class TextProvider extends ItemViewBinder<String, TextViewHolder> {
    @NonNull
    @Override
    protected TextViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(TextViewHolder.getLayoutId(), parent, false);
        return new TextViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull TextViewHolder holder, @NonNull String item) {
        holder.fillData(item);
    }
}
