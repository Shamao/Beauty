package com.louise.base.manager;

import android.app.Activity;

import java.util.Stack;

/**
 * @author lsd
 * @date 2018/2/6.
 */

public class InterfaceManager {

    private static Stack<Activity> mActivityStack;
    private static InterfaceManager mInstance;


    private InterfaceManager() {
        mActivityStack = new Stack<>();
    }

    /**
     * 单一实例
     */
    public static InterfaceManager getInstance() {
        if (mInstance == null) {
            mInstance = new InterfaceManager();
        }
        return mInstance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        mActivityStack.push(activity);
    }

    /**
     * 移除当前Activity（堆栈中最后一个压入的）
     */
    public void removeActivity(Activity activity) {
        if (activity != null && mActivityStack.contains(activity)) {
            mActivityStack.pop();
        }
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity getCurActivity() {
        if (mActivityStack.empty()) {
            throw new NullPointerException("activity堆栈无<activity>实例");
        } else {
            return mActivityStack.peek();
        }
    }


    public Activity[] getAllActivities() {
        Activity[] activities = new Activity[mActivityStack.size()];
        mActivityStack.copyInto(activities);
        return activities;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishCurrentActivity() {
        if (mActivityStack.size() > 1) {
            Activity activity = mActivityStack.lastElement();
            finishActivity(activity);
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.removeElement(activity);
            activity.finish();
        }
    }

}
