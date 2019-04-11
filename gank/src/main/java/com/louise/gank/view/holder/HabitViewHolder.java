package com.louise.gank.view.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.louise.base.view.flexbox.UIFlexBoxView;
import com.louise.gank.R;
import com.louise.gank.bean.MHabit;

import cc.hiy.baseui.base.BaseRecyclerViewHolder;

/**
 * @author lsd
 * @date 2019/1/10.
 *
 */
public class HabitViewHolder extends BaseRecyclerViewHolder {

    public static int getLayoutId() {
        return R.layout.gank_item_view_habit;
    }

    private ImageView mThumbIv;
    private TextView mTitleTv;
    private UIFlexBoxView mDayFlexView;


    public HabitViewHolder(View itemView) {
        super(itemView);
        mThumbIv = findViewById(R.id.habit_thumb_iv);
        mTitleTv = findViewById(R.id.habit_title_tv);
        mDayFlexView = findViewById(R.id.habit_flex_view);
    }


    public void fillData(MHabit target) {
            // todo
         mThumbIv.setImageResource(R.drawable.gank_ic_banner_38);
         mTitleTv.setText("习惯");
    }


}
