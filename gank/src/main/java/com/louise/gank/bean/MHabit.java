package com.louise.gank.bean;

import android.arch.persistence.room.Entity;

import java.util.Calendar;
import java.util.Random;

/**
 * 习惯类
 *
 * @author lsd
 * @date 2019/1/4.
 */
@Entity(tableName = "goods")
public class MHabit {

    /**
     * 静态生成 id todo 需要优化
     * @return
     */
    public static long generateId() {
        Calendar calendar = Calendar.getInstance();
        long millis= calendar.getTimeInMillis();
        int end = new Random().nextInt(10);
        return  millis * 10 + end;
    }

    private long mId;
    private String mName;
    private String mGoal;
    private int mNum;
    private String mUnit;
    private int repeat;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getGoal() {
        return mGoal;
    }

    public void setGoal(String goal) {
        mGoal = goal;
    }

    public int getNum() {
        return mNum;
    }

    public void setNum(int num) {
        mNum = num;
    }

    public String getUnit() {
        return mUnit;
    }

    public void setUnit(String unit) {
        mUnit = unit;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    @Override
    public String toString() {
        return "MHabit{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mGoal='" + mGoal + '\'' +
                ", mNum=" + mNum +
                ", mUnit='" + mUnit + '\'' +
                ", repeat=" + repeat +
                '}';
    }
}
