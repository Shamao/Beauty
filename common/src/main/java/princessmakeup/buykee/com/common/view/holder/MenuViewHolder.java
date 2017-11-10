package princessmakeup.buykee.com.common.view.holder;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import princessmakeup.buykee.com.common.R;
import princessmakeup.buykee.com.common.R2;
import princessmakeup.buykee.com.common.base.BaseViewHolder;
import princessmakeup.buykee.com.common.bean.MolStringBean;

/**
 * @author lsd
 * @date 2017/11/8.
 */

public class MenuViewHolder extends BaseViewHolder {

    public static int getLayoutId() {
        return R.layout.item_menu;
    }

    @BindView(R2.id.text_tv)
    TextView mTextTv;

    public MenuViewHolder(View itemView) {
        super(itemView);
    }

    public void fillData(final MolStringBean item) {
        mTextTv.setText(item.getContent());
    }
}
