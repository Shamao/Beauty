package com.louise.base.utils;

import android.app.Activity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lsd
 * @date 2018/3/22.
 */

public class ActivityStack {
    private static final String S_TAG = "s_activity_stack";

    private List<Activity> mActivityList;

    public static class Holder {
        public static ActivityStack instance = new ActivityStack();
    }

    public static ActivityStack getInstance() {
        return Holder.instance;
    }

    private ActivityStack() {
        mActivityList = Collections.synchronizedList(new LinkedList<Activity>());
    }


    public void addActivity(Activity activity) {
        if (activity == null) {
            return;
        }
        mActivityList.add(activity);
        ALogger.d(S_TAG, "addActivity", mActivityList.toString());
    }

    public void removeActivity(Activity activity) {
        if (activity == null) {
            return;
        }
        mActivityList.remove(activity);
        ALogger.d(S_TAG, "removeActivity", mActivityList.toString());
    }

    /**
     * get top activity
     *
     * @return activity
     */
    public Activity getTopActivity() {
        if (mActivityList == null || mActivityList.isEmpty()) {
            return null;
        }
        return mActivityList.get(mActivityList.size() - 1);
    }

    public void finishActivity(Activity activity) {
        if (mActivityList == null || mActivityList.isEmpty()) {
            return;
        }
        if (activity == null) {
            return;
        }
        removeActivity(activity);
        activity.finish();
    }


    public boolean finishActivity(Class<? extends Activity> clz) {
        if (mActivityList == null || mActivityList.isEmpty()) {
            return false;
        }

        for (int i = 0; i < mActivityList.size(); i++) {
            Activity activity = mActivityList.get(i);
            if (activity.getClass() == clz) {
                finishActivity(activity);
                return true;
            }
        }

        return false;
    }


    /**
     * check if all activity had bean finished
     *
     * @return true or false
     */
    public boolean isAllActivityFinished() {
        return mActivityList == null || mActivityList.isEmpty();
    }

}
