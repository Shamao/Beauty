package com.louise.lab.view.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.louise.base.utils.DisplayUtils;
import com.louise.base.utils.ALogger;
import com.louise.base.utils.constance.ConstTag;

/**
 * @author lsd
 * @date 2018/3/14.
 */

public class LabBehavior extends CoordinatorLayout.Behavior<RecyclerView> {

    public LabBehavior() {
    }

    public LabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, RecyclerView child, int layoutDirection) {
        ALogger.d(ConstTag.S_VIEW, "onLayoutChild");
        parent.onLayoutChild(child, layoutDirection);
        child.offsetChildrenVertical((int) (DisplayUtils.getScreenWidth(parent.getContext()) * 0.6));
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, RecyclerView child, MotionEvent ev) {
        if (child.getTop() > 0) {
            return false;
        }
        return super.onInterceptTouchEvent(parent, child, ev);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView child,
                                       @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        Log.e(ConstTag.S_VIEW, "onStartNestedScroll");
        if (child.getTop() > 0) {
            return true;
        }

        if (child.getScrollY() == 0) {
            return true;
        } else {
            return false;
        }
        //        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        child.offsetChildrenVertical(child.getTop() + dy);
    }

    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView child, @NonNull View target, int type) {
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed,
                             type);
    }
}
