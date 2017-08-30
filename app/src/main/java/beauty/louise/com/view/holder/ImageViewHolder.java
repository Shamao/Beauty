package beauty.louise.com.view.holder;

import android.view.View;
import android.widget.ImageView;

import beauty.louise.com.R;
import beauty.louise.com.base.BaseViewHolder;
import butterknife.BindView;

/**
 * Created by lsd on 17/8/31.
 */

public class ImageViewHolder extends BaseViewHolder {
    public static int getLayoutId() {
        return R.layout.item_img;
    }

    @BindView(R.id.cover_iv)
    ImageView mCoverIv;

    public ImageViewHolder(View itemView) {
        super(itemView);
    }

    public void fillData() {

    }
}
