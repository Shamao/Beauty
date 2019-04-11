package com.louise.base.base;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.louise.base.utils.ALogger;
import com.louise.base.utils.constance.ConstTag;

/**
 * @author lsd
 * @date 2018/2/9.
 */

public abstract class BaseView extends View {

    public abstract void initAttr(Context context, AttributeSet attrs);

    protected String mTag;

    public BaseView(Context context) {
        this(context, null);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTag = getClass().getSimpleName() + hashCode();
        initAttr(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        ALogger.d(ConstTag.S_VIEW, mTag, "onMeasure", widthMode, widthSize, heightMode, heightSize);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        ALogger.d(ConstTag.S_VIEW, mTag, "onLayout");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        ALogger.d(ConstTag.S_VIEW, mTag, "onSizeChanged");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ALogger.d(ConstTag.S_VIEW, mTag, "onDraw");
    }
}

