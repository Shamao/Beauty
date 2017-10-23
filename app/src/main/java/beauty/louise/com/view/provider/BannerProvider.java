package beauty.louise.com.view.provider;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import beauty.louise.com.R;
import beauty.louise.com.bean.helper.MCoverList;
import beauty.louise.com.view.holder.BannerViewHolder;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by lsd on 17/9/22.
 */

public class BannerProvider extends ItemViewBinder<MCoverList, BannerViewHolder> {

    @NonNull
    @Override
    protected BannerViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_banner, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull BannerViewHolder holder, @NonNull MCoverList item) {
        holder.fillData(item.getList());
    }
}
