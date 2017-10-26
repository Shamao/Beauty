package beauty.louise.com.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.alibaba.mtl.log.utils.Logger;

import beauty.louise.com.R;
import beauty.louise.com.Utils.Constant.ConstTag;

/**
 * Created by lsd on 17/9/19.
 */

public class UIRatioImageView extends ImageView {

    private static final String mTag = UIRatioImageView.class.getSimpleName() + UIRatioImageView.class.hashCode();
    public static final int WIDTH = 0;
    public static final int HEIGHT = 1;

    private int mHorizontalWeight;//宽的权重
    private int mVerticalWeight;//高的权重
    private int mBaseLine;//基准线
    private int mSpecifiedWidth, mSpecifiedHeight;

    public UIRatioImageView(Context context) {
        super(context);
        init(context, null);
    }

    public UIRatioImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public UIRatioImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public UIRatioImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.UIRatioImageView);
            mHorizontalWeight = ta.getInt(R.styleable.UIRatioImageView_horizontal_weight, 0);
            mVerticalWeight = ta.getInt(R.styleable.UIRatioImageView_vertical_weight, 0);
            mBaseLine = ta.getInt(R.styleable.UIRatioImageView_base_line, WIDTH);
            ta.recycle();
        }
        setScaleType(ScaleType.FIT_CENTER);
    }

    //calculate imageView'size（width and height）
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Logger.d(ConstTag.S_CUSTOM_VIEW, mTag, "onMeasure");
        if (mHorizontalWeight == 0 || mVerticalWeight == 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }

        int desiredWidth = 0, desiredHeight = 0;
        if (mBaseLine == WIDTH) {
            if (mSpecifiedWidth != 0) {
                desiredWidth = mSpecifiedWidth;
            } else {
                desiredWidth = MeasureSpec.getSize(widthMeasureSpec);
            }

            float ratio = (mVerticalWeight * 1.0f) / mHorizontalWeight;
            desiredHeight = (int) (desiredWidth * ratio);
        }

        if (desiredHeight == 0 || desiredWidth == 0) {
            mBaseLine = HEIGHT;
        }

        if (mBaseLine == HEIGHT) {
            if (mSpecifiedHeight != 0) {
                desiredHeight = mSpecifiedHeight;
            } else {
                desiredHeight = MeasureSpec.getSize(heightMeasureSpec);
            }

            if (mVerticalWeight != 0 || mHorizontalWeight != 0) {
                float ratio = (mHorizontalWeight * 1.0f) / mVerticalWeight;
                desiredWidth = (int) (desiredHeight * ratio);
            }
        }

        if (desiredWidth > 0 && desiredHeight > 0) {
            setMeasuredDimension(desiredWidth, desiredHeight);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Logger.d(ConstTag.S_CUSTOM_VIEW, mTag, "onLayout");

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Logger.d(ConstTag.S_CUSTOM_VIEW, mTag, "onSizeChanged");

    }

    /**
     * 设定View的宽度,此时View的基准会变为{@link #WIDTH}
     */
    public void setWidth(int width) {
        mSpecifiedWidth = width;
        setBaseLine(WIDTH);
    }

    /**
     * 设定View的高度,此时View的基准会变为{@link #HEIGHT}
     */
    public void setHeight(int height) {
        mSpecifiedHeight = height;
        setBaseLine(HEIGHT);
    }

    public int getVerticalWeight() {
        return mVerticalWeight;
    }

    public void setVerticalWeight(int verticalWeight) {
        if (mVerticalWeight != verticalWeight) {
            mVerticalWeight = verticalWeight;
            requestLayout();
        }
    }

    public int getHorizontalWeight() {
        return mHorizontalWeight;
    }

    public void setHorizontalWeight(int horizontalWeight) {
        if (mHorizontalWeight != horizontalWeight) {
            mHorizontalWeight = horizontalWeight;
            requestLayout();
        }
    }

    /**
     * 设置当前的基准线
     */
    public void setBaseLine(int baseLine) {
        mBaseLine = baseLine;
        requestLayout();
    }

    /**
     * 获取当前的基准线
     */
    public int getBaseLine() {
        return mBaseLine;
    }

    @Override
    public void setScaleType(ScaleType scaleType) {
        if (ScaleType.CENTER_CROP == scaleType || ScaleType.FIT_CENTER == scaleType) {
            super.setScaleType(scaleType);
        }
    }


}
