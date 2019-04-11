package com.louise.gank.bean;

/**
 * 习惯类-日期类
 *
 * @author lsd
 * @date 2019/4/1.
 */
public class MHabitDay {
    private int day;          // 当前天  参考calendar.get(Calendar.DAY_OF_WEEK)
    private boolean isSelect; // 0 : 未选中 1 ： 选中

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
