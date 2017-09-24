package beauty.louise.com.view.holder;

import android.text.TextUtils;
import android.view.View;

import beauty.louise.com.R;
import beauty.louise.com.Utils.GlideUtils;
import beauty.louise.com.base.BaseViewHolder;
import beauty.louise.com.bean.MImageBean;
import beauty.louise.com.view.UIRatioImageView;
import butterknife.BindView;

import static beauty.louise.com.R.id.cover_iv;

/**
 * Created by lsd on 17/8/31.
 */

public class ImageViewHolder extends BaseViewHolder {
    public static int getLayoutId() {
        return R.layout.item_img;
    }

    @BindView(cover_iv)
    UIRatioImageView mCoverIv;

    public ImageViewHolder(View itemView) {
        super(itemView);
    }

    public void fillData(MImageBean item) {
        int width = item.getWidth();
        int height = item.getHeight();
        mCoverIv.setHorizontalWeight(width);
        mCoverIv.setVerticalWeight(height);

        String imageUrl = "";
        int imageRes = item.getImageRes();
        if (!TextUtils.isEmpty(imageUrl)) {
            GlideUtils.displayImageByRate(itemView.getContext(), imageUrl, width, height)
                    .crossFade()
//                    .override(width, height)
                    .into(mCoverIv);
        } else if (imageRes > 0) {
            mCoverIv.setImageResource(imageRes);
        } else {
            mCoverIv.setImageResource(R.drawable.ph_planet);
        }
    }
}
