package princessmakeup.buykee.com.common.view.holder;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import princessmakeup.buykee.com.common.R;
import princessmakeup.buykee.com.common.R2;
import princessmakeup.buykee.com.common.base.BaseViewHolder;
import princessmakeup.buykee.com.common.bean.MolColumnBean;
import princessmakeup.buykee.com.common.bean.MolLayoutBean;
import princessmakeup.buykee.com.common.utils.ActivityUtils;

/**
 * @author lsd
 * @date 2017/11/9.
 */

public class ColumnViewHolder extends BaseViewHolder {
    public static int getLayoutId() {
        return R.layout.item_column;
    }

    @BindView(R2.id.column_root_layout)
    View mRootView;
    @BindView(R2.id.column_title_tv)
    TextView mTitleTv;
    @BindView(R2.id.column_desc_tv)
    TextView mDescTv;

    public ColumnViewHolder(View itemView) {
        super(itemView);
    }

    public void fillData(final MolColumnBean columnBean) {
        fillLayout(columnBean.getLayoutBean());
        fillTitleLayout(columnBean.getLayoutBean());
        mTitleTv.setText(columnBean.getTitle());
        mDescTv.setText(columnBean.getDesc());
        mDescTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String schema = columnBean.getDescSchema();
                if (schema.contains("://")) {
                    Uri uri = Uri.parse(schema);
                    ActivityUtils.startActivity(getContext(), Intent.ACTION_VIEW, schema, 0);
//                    ARouter.getInstance().build(uri).navigation();
                } else {
                    ARouter.getInstance().build(schema).navigation();

                }
            }
        });
    }


    public void fillTitleLayout(MolLayoutBean layoutBean) {
        if (layoutBean == null) {
            return;
        }

        int gravity = layoutBean.getTitleGravity();
        if (gravity != Gravity.NO_GRAVITY) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mTitleTv.getLayoutParams();
            lp.gravity = gravity;
            mTitleTv.setLayoutParams(lp);
        }

        int titleColorRes = layoutBean.getTitleColorRes();
        if (titleColorRes > 0) {
            int titleColor = itemView.getContext().getResources().getColor(titleColorRes);
            mTitleTv.setTextColor(titleColor);
        }

        int titleSize = layoutBean.getTitleSizeSp();
        if (titleSize > 0) {
            mTitleTv.setTextSize(titleSize);
        }

        Typeface typeface = layoutBean.getTitleTypeFace();
        if (typeface != null) {
            mTitleTv.setTypeface(typeface);
        }
    }

}
