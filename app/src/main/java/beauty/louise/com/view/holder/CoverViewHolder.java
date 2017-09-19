package beauty.louise.com.view.holder;

import android.view.View;
import android.widget.ImageView;

import beauty.louise.com.R;
import beauty.louise.com.base.BaseViewHolder;
import beauty.louise.com.ui.PlayerActivity;
import butterknife.BindView;
import princessmakeup.buykee.com.common.manager.AppManager;

/**
 * Created by lsd on 17/8/31.
 */

public class CoverViewHolder extends BaseViewHolder {
    public static int getLayoutId() {
        return R.layout.item_cover;
    }

    @BindView(R.id.cover_iv)
    ImageView mCoverIv;

    public CoverViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayerActivity.startActivity(AppManager.getInstance().getCurActivity(), "null");
            }
        });
    }

    public void fillData() {

    }
}
