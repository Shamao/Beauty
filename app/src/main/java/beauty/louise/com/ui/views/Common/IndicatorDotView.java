package beauty.louise.com.ui.views.Common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lsd on 17/3/6.
 */

public class IndicatorDotView extends View {
    private static final int S_D_SIZE = 10;
    private static final int S_D_COLOR = Color.GREEN;

    private int mColor;

    private int mInitSize;
    private int mResultWidth;
    private int mResultHeight;

    private Paint mPaint;
    private RectF rectF;

    public IndicatorDotView(Context context) {
        super(context);
        init();
    }

    public IndicatorDotView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public IndicatorDotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);

        mInitSize = dp2px(S_D_SIZE);//int)(getContext().getResources().getDisplayMetrics().density * +0.5);
        mResultWidth = mInitSize;
        mResultHeight = mInitSize;

        rectF = new RectF(0, 0, mResultWidth, mResultHeight);
        mColor = S_D_COLOR;

    }

    public void config(int color, int initSize) {
        this.mColor = color;
        this.mInitSize = initSize;
        mResultWidth = mInitSize;
        mResultHeight = mInitSize;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mResultWidth = getSize(widthMeasureSpec, mResultWidth);
        mResultHeight = getSize(heightMeasureSpec, mResultHeight);
        rectF.set(0, 0, mResultWidth, mResultHeight);
        setMeasuredDimension(mResultWidth, mResultHeight);
    }

    private int getSize(int measureSpec, int defaultSize) {
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        int tempSize;
        switch (mode) {
            case MeasureSpec.UNSPECIFIED: {//如果没有指定大小，就设置为默认大小
                tempSize = defaultSize;
                break;
            }
            case MeasureSpec.AT_MOST: {//如果测量模式是最大取值为size
                //我们将大小取最大值,你也可以取其他值
                tempSize = Math.max(Math.min(size, defaultSize), mInitSize);
                break;
            }
            case MeasureSpec.EXACTLY: {//如果是固定的大小，那就不要去改变它
                tempSize = size;
                break;
            }
            default:
                tempSize = defaultSize;
                break;
        }
        return tempSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mColor);
        int radius = (int) (Math.min(rectF.width(), rectF.height()) / 2);
        canvas.drawRoundRect(rectF, radius, radius, mPaint);
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
        invalidate();
    }

    public void setResultWidth(int resultWidth) {
        mResultWidth = resultWidth;
        requestLayout();
    }

    public void setResultHeight(int resultHeight) {
        mResultHeight = resultHeight;
        requestLayout();
    }


    public int getDefaultSize() {
        return mInitSize;
    }


    private int dp2px(int dp) {
        return (int) (getContext().getResources().getDisplayMetrics().density * dp + 0.5);
    }
}
