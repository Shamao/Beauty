package beauty.louise.com.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

import beauty.louise.com.R;

/**
 * Created by lsd on 17/9/19.
 */

public class UIRatioImageView extends ImageView {

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
            mHorizontalWeight = ta.getInt(R.styleable.UIRatioImageView_horizontal_weight, 1);
            mVerticalWeight = ta.getInt(R.styleable.UIRatioImageView_vertical_weight, 1);
            mBaseLine = ta.getInt(R.styleable.UIRatioImageView_base_line, WIDTH);
            ta.recycle();
        }
        setScaleType(ScaleType.CENTER_CROP);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
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

        if (desiredHeight == 0 && desiredWidth == 0) {
            mBaseLine = HEIGHT;
        }

        if (mBaseLine == HEIGHT) {
            if (mSpecifiedHeight != 0) {
                desiredHeight = mSpecifiedHeight;
            } else {
                desiredHeight = MeasureSpec.getSize(heightMeasureSpec);
            }
            float ratio = (mHorizontalWeight * 1.0f) / mVerticalWeight;
            desiredWidth = (int) (desiredHeight * ratio);
        }

        setMeasuredDimension(desiredWidth, desiredHeight);
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
        mVerticalWeight = verticalWeight;
        requestLayout();
    }

    public int getHorizontalWeight() {

        return mHorizontalWeight;
    }

    public void setHorizontalWeight(int horizontalWeight) {
        mHorizontalWeight = horizontalWeight;
        requestLayout();
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
