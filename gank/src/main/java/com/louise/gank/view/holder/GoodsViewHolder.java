package com.louise.gank.view.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cc.hiy.baseui.flexbox.UIFlexBoxView;
import com.louise.gank.R;
import com.louise.gank.bean.MGoods;
import com.louise.gank.bean.MHabit;

import cc.hiy.baseui.base.BaseRecyclerViewHolder;

/**
 * @author lsd
 * @date 2019/1/10.
 *
 */
public class GoodsViewHolder extends BaseRecyclerViewHolder {

    public static int getLayoutId() {
        return R.layout.gank_item_view_habit;
    }

    private ImageView mThumbIv;
    private TextView mTitleTv;


    public GoodsViewHolder(View itemView) {
        super(itemView);
        mThumbIv = findViewById(R.id.habit_thumb_iv);
        mTitleTv = findViewById(R.id.habit_title_tv);
    }


    public void fillData(MGoods goods) {
         mTitleTv.setText(goods.id + "" + goods.name);
    }


}
