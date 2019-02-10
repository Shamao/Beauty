package com.louise.gank.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.louise.gank.R;
import com.louise.gank.bean.MHabit;

/**
 * @author lsd
 * @date 2019/1/10.
 */
public class HabitViewHolder extends RecyclerView.ViewHolder {

    public static int getLayoutId() {
        return R.layout.gank_item_view_habit;
    }

    private ImageView mThumbIv;
    private TextView mTitleTv;
    private TextView mGoalTv;


    public HabitViewHolder(View itemView) {
        super(itemView);
        mThumbIv = itemView.findViewById(R.id.habit_thumb_iv);
        mTitleTv = itemView.findViewById(R.id.habit_title_tv);
        mGoalTv = itemView.findViewById(R.id.habit_goal_tv);
    }


    public void fillData(MHabit target) {
            // todo
         mThumbIv.setImageResource(R.drawable.gank_ic_banner_38);

         mTitleTv.setText("习惯");
         mGoalTv.setText("目标");
    }


}
