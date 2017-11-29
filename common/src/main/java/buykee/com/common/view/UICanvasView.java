package buykee.com.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lsd on 2017/10/31.
 */

public class UICanvasView extends View {

    public static final int S_SHOW_PART_1 = 0;
    public static final int S_SHOW_PART_2 = 1;
    public static final int S_SHOW_PART_3 = 2;
    private Paint mPaint = new Paint();

    private int mShowType;

    public UICanvasView(Context context) {
        this(context, null);
    }

    public UICanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UICanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setColor(Color.BLACK);       //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mPaint.setStrokeWidth(1f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPart(canvas);
    }


    public void setShowType(int showType) {
        mShowType = showType;
        invalidate();
    }

    private void drawPart(Canvas canvas) {
        //背景
        canvas.drawColor(Color.GRAY);
        //点  0-> 50
        canvas.drawPoint(25, 25, mPaint);
        canvas.drawPoints(new float[]{100f, 25f, 200f, 25f}, mPaint);

        //线 50 --> 100
        mPaint.setColor(Color.RED);
        canvas.drawLine(0, 50, 100, 100, mPaint);
        canvas.drawLines(new float[]{
                100, 100, 250, 60,
                175, 75, 720, 75
        }, mPaint);
        //矩形 100 - > 200
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 100, 100, 200, mPaint);

        mPaint.setColor(Color.RED);
        Rect rect = new Rect(200, 100, 300, 200);
        canvas.drawRect(rect, mPaint);

        mPaint.setColor(Color.YELLOW);
        RectF rectF = new RectF(400, 100, 500, 200);
        canvas.drawRect(rectF, mPaint);

        //圆角矩形  250-> 350
        RectF rectF1 = new RectF(0, 250, 100, 350);
        canvas.drawRoundRect(rectF1, 30, 30, mPaint);
        canvas.drawRoundRect(250, 250, 400, 350, 30, 30, mPaint);


        //椭圆 // 400 -> 500
        RectF rectF2 = new RectF(100, 400, 300, 500);
        canvas.drawOval(rectF2, mPaint);
        canvas.drawOval(300, 400, 700, 500, mPaint);
        //园  500-> 600
        canvas.drawCircle(100, 550, 50, mPaint);
        //绘制圆弧 600->800
        //1
        RectF rectF3 = new RectF(100, 600, 400, 800);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rectF3, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF3, -90, 90, false, mPaint);
        //2
        RectF rectF4 = new RectF(410, 600, 900, 800);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rectF4, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF4, 180, -90, false, mPaint);

        //paint 900->1000
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(100, 950, 50, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20.f);
        canvas.drawCircle(300, 950, 50, mPaint);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(500, 950, 50, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawLine(0, 900, getContext().getResources().getDisplayMetrics().widthPixels, 900, mPaint);
        canvas.drawLine(0, 1000, getContext().getResources().getDisplayMetrics().widthPixels, 1000, mPaint);


        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(20);
        canvas.drawLine(0, 2000, getContext().getResources().getDisplayMetrics().widthPixels, 2000, mPaint);
    }
}
