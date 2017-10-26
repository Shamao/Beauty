package princessmakeup.buykee.com.lab.view.holder;

import android.view.View;
import android.widget.TextView;

import princessmakeup.buykee.com.common.base.BaseViewHolder;
import princessmakeup.buykee.com.common.manager.AppManager;
import princessmakeup.buykee.com.common.utils.ActivityUtils;
import princessmakeup.buykee.com.lab.LabDrawableActivity;
import princessmakeup.buykee.com.lab.R;

/**
 * Created by lsd on 2017/10/20.
 */

public class TextViewHolder extends BaseViewHolder {
    public static int getLayoutId() {
        return R.layout.lab_item_text;
    }

    private TextView mTextTv;

    public TextViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView() {
        mTextTv = itemView.findViewById(R.id.lab_text_tv);
    }

    public void fillData(String item) {
        mTextTv.setText(item);
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = TextViewHolder.this.getAdapterPosition();
                if (position == 0) {
                    ActivityUtils.startActivity(AppManager.getInstance().getCurActivity(), LabDrawableActivity.class);
                }
            }
        });
    }
}
