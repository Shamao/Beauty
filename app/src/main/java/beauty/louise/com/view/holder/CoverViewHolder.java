package beauty.louise.com.view.holder;

import android.text.TextUtils;
import android.view.View;

import com.bumptech.glide.request.target.Target;

import beauty.louise.com.R;
import beauty.louise.com.Utils.GlideUtils;
import beauty.louise.com.bean.MCoverBean;
import beauty.louise.com.view.UIRatioImageView;
import butterknife.BindView;
import buykee.com.common.base.BaseViewHolder;


/**
 * Created by lsd on 17/8/31.
 */

public class CoverViewHolder extends BaseViewHolder {
    public static int getLayoutId() {
        return R.layout.item_cover;
    }

    @BindView(R.id.cover_iv)
    UIRatioImageView mCoverIv;

    public CoverViewHolder(View itemView) {
        super(itemView);
    }

    public void fillData(MCoverBean item) {
        int width = item.getWidth();
        int height = item.getHeight();
        mCoverIv.setHorizontalWeight(width);
        mCoverIv.setVerticalWeight(height);
        width = mCoverIv.getWidth();
        height = mCoverIv.getHeight();
        if (width == 0 || height == 0) {
            width = Target.SIZE_ORIGINAL;
            height = Target.SIZE_ORIGINAL;
        }

        String imageUrl = item.getImageUrl();
        int imageRes = item.getImageRes();
        if (!TextUtils.isEmpty(imageUrl)) {
            GlideUtils.displayImageByRate(itemView.getContext(), imageUrl)
                    .dontAnimate()
                    .override(width, height)
                    .into(mCoverIv);
        } else if (imageRes > 0) {
            mCoverIv.setImageResource(imageRes);
        } else {
            mCoverIv.setImageResource(R.drawable.ph_planet);
        }
    }
}
