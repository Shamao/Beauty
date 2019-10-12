package com.louise.gank.view.holder;

import android.view.View;
import android.widget.TextView;

import com.louise.gank.R;

import cc.hiy.baseui.base.BaseRecyclerViewHolder;


public class JsonViewHolder extends BaseRecyclerViewHolder {

    public static int getLayoutId() {
        return R.layout.gank_item_view_json;
    }

    private TextView mJsonTv;

    public JsonViewHolder(View itemView) {
        super(itemView);
        mJsonTv = itemView.findViewById(R.id.json_tv);
    }

    public void fillData(String json) {
        mJsonTv.setText(json);
    }
}
