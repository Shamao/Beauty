package com.louise.gank.adapter;

import android.view.View;
import android.widget.TextView;

import com.louise.gank.R;

import cc.hiy.baseui.base.BaseRecyclerViewHolder;

/**
 * @author zhishui <a href="mailto:liusd@tuya.com">Contact me.</a>
 * @since 2019-10-14
 */
public class StringViewHolder extends BaseRecyclerViewHolder {

    public static int getlayoutId() {
        return R.layout.gank_item_view_json;
    }


    public StringViewHolder(View itemView) {
        super(itemView);
    }

    public void fillData(String json) {
        ((TextView) findViewById(R.id.json_tv)).setText(json);
    }


}
