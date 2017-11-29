package buykee.com.common.view.holder;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import buykee.com.common.base.BaseViewHolder;
import buykee.com.common.bean.MolStringBean;
import buykee.com.common.R;
import buykee.com.common.R2;

/**
 * @author lsd
 * @date 2017/11/8.
 */

public class MenuBlockViewHolder extends BaseViewHolder {

    public static int getLayoutId() {
        return R.layout.item_menu_block;
    }

    @BindView(R2.id.text_tv)
    TextView mTextTv;

    public MenuBlockViewHolder(View itemView) {
        super(itemView);
    }

    public void fillData(MolStringBean item) {
        mTextTv.setText(item.getContent());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //schema 跳转
            }
        });
    }
}
