package princessmakeup.buykee.com.common.view.holder;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import princessmakeup.buykee.com.common.R;
import princessmakeup.buykee.com.common.R2;
import princessmakeup.buykee.com.common.base.BaseViewHolder;
import princessmakeup.buykee.com.common.bean.MStringBean;

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

    public void fillData(final MStringBean item) {
        mTextTv.setText(item.getContent());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //schema 跳转
                ARouter.getInstance().build(item.getSchema()).navigation();
            }
        });
    }
}
