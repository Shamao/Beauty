package com.louise.lab.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.louise.base.manager.RouterManager;
import com.louise.lab.R;
import com.louise.lab.R2;
import com.louise.lab.bean.MMenuBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lsd
 * @date 2018/2/7.
 */

public class SimpleMenuViewHolder extends RecyclerView.ViewHolder {

    public static int getLayoutId() {
        return R.layout.lab_item_menu;
    }

    @BindView(R2.id.lab_title_tv)
    TextView mTitleTv;

    public SimpleMenuViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void fillData(final MMenuBean item) {
        mTitleTv.setText(item.getTitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterManager.getInstance().navigation(v.getContext(), item.getSchema());
            }
        });
    }
}
