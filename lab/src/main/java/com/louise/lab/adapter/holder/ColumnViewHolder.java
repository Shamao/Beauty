package com.louise.lab.adapter.holder;

import android.content.res.ColorStateList;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.louise.lab.R;
import com.louise.lab.R2;
import com.louise.lab.bean.MColumnBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lsd
 * @date 2018/2/7.
 */

public class ColumnViewHolder extends RecyclerView.ViewHolder {

    public static int getLayoutId() {
        return R.layout.lab_item_column;
    }

    @BindView(R2.id.lab_title_tv)
    TextView mTitleTv;

    public ColumnViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void fillData(MColumnBean item) {
        mTitleTv.setText(item.getTitle());

        ColorStateList color = itemView.getResources().getColorStateList(R.color.lab_selector_bg_btn);
    }
}