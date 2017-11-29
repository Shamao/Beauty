package buykee.com.common.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import buykee.com.common.utils.Logger;
import buykee.com.common.utils.constant.ConstTag;

/**
 * @author lsd
 * @date 17/2/6
 */

public abstract class BaseView extends View {
    protected static String mTag;


    public abstract void initView();

    public void initListener() {
    }

    public void initAttrs(AttributeSet attrs) {
    }

    public BaseView(Context context) {
        this(context, null);
    }

    public BaseView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTag = getClass().getSimpleName();
        initAttrs(attrs);
        initView();
        initListener();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.d(ConstTag.S_CUSTOM, mTag, "onTouchEvent", super.onTouchEvent(event));
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logger.d(ConstTag.S_CUSTOM,mTag, "dispatchTouchEvent", super.dispatchTouchEvent(ev));
        return super.dispatchTouchEvent(ev);
    }

    protected int dp2px(int dp) {
        return (int) (getContext().getResources().getDisplayMetrics().density * dp + 0.5);
    }

    protected int getScreenHeight() {
        return getContext().getResources().getDisplayMetrics().heightPixels;
    }

    protected int getScreenWidth() {
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }


}
