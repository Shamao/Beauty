package beauty.louise.com.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import beauty.louise.com.bean.MImageBean;
import beauty.louise.com.view.holder.ImageViewHolder;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by lsd on 17/8/31.
 */

public class ImageProvider extends ItemViewBinder<MImageBean, ImageViewHolder> {
    @NonNull
    @Override
    protected ImageViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(ImageViewHolder.getLayoutId(), parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ImageViewHolder holder, @NonNull MImageBean item) {
        holder.fillData(item);
    }
}
