package buykee.com.common.view.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import buykee.com.common.base.BaseViewHolder;
import buykee.com.common.R;
import buykee.com.common.R2;

/**
 * @author lsd
 * @date 2017/11/14.
 */

public class UserViewHolder extends BaseViewHolder {
    public static int getLayoutId() {
        return R.layout.item_user;
    }

    @BindView(R2.id.avatar_iv)
    ImageView mAvatarIv;
    @BindView(R2.id.user_name_tv)
    TextView mUserNameTv;
    @BindView(R2.id.desc_tv)
    TextView mDescTv;

    public UserViewHolder(View itemView) {
        super(itemView);
    }


}
