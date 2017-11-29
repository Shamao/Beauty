package buykee.com.common.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import buykee.com.common.utils.Logger;
import buykee.com.common.utils.constant.ConstTag;

/**
 *
 * @author lsd
 * @date 17/2/6
 */

public abstract class BaseLayout extends FrameLayout {
    protected static String mTag;

    public abstract int getLayoutId();

    public abstract void initView();

    public void initListener() {
    }

    public void initAttrs(AttributeSet attrs) {
    }

    public BaseLayout(Context context) {
        this(context, null);
    }

    public BaseLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTag = getClass().getSimpleName() + "@" + hashCode();
        initAttrs(attrs);
        if (getLayoutId() > 0) {
            View.inflate(getContext(), getLayoutId(), this);
            ButterKnife.bind(this);
        }
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
        Logger.d(ConstTag.S_CUSTOM, mTag, "dispatchTouchEvent", super.dispatchTouchEvent(ev));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logger.d(ConstTag.S_CUSTOM, mTag, "onInterceptTouchEvent", super.onInterceptTouchEvent(ev));
        return super.onInterceptTouchEvent(ev);
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
