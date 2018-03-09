package com.louise.gank.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * @author lsd
 * @date 2018/3/5.
 */

public class MUserBean extends BaseObservable{
    private String mName;
    private String mDesc;
    private int mGender;

    public MUserBean(String name, String desc) {
        mName = name;
        mDesc = desc;
    }

    @Bindable
    public String getDesc() {
        return mDesc;
    }

    @Bindable
    public void setDesc(String desc) {
        mDesc = desc;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getGender() {
        return mGender;
    }

    public void setGender(int gender) {
        mGender = gender;
    }
}
