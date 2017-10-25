package beauty.louise.com.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import beauty.louise.com.R;
import beauty.louise.com.bean.helper.MTagList;
import beauty.louise.com.view.holder.TagViewHolder;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by lsd on 2017/10/25.
 */

public class TagProvider extends ItemViewBinder<MTagList, TagViewHolder> {
    @NonNull
    @Override
    protected TagViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_tag_area, parent, false);
        return new TagViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull TagViewHolder holder, @NonNull MTagList item) {
        holder.fillData(item.getList());
    }
}
