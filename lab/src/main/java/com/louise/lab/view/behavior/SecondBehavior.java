package com.louise.lab.view.behavior;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.louise.base.utils.ALogger;
import com.louise.base.utils.constance.ConstTag;

/**
 * @author lsd
 * @date 2018/3/14.
 */

public class SecondBehavior extends CoordinatorLayout.Behavior<ConstraintLayout> {

    public SecondBehavior() {
    }

    public SecondBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, ConstraintLayout child, int layoutDirection) {
        ALogger.d(ConstTag.S_VIEW, "onLayoutChild");
        parent.onLayoutChild(child, layoutDirection);
        return true;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ConstraintLayout child, View dependency) {
        return dependency instanceof RecyclerView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ConstraintLayout child, View dependency) {
        ALogger.d(ConstTag.S_VIEW, "onDependentViewChanged", dependency.getTop(), dependency.getScrollY());
        if (dependency.getTop() == 0 && dependency.getScrollY() >= 0) {
            return false;
        }
        parent.onLayoutChild(child, dependency.getTop() - child.getMeasuredHeight());
        return true;
        //        return super.onDependentViewChanged(parent, child, dependency);
    }
}
