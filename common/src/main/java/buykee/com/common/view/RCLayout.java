package buykee.com.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;

import buykee.com.common.R;
import buykee.com.common.base.BaseLayout;
import buykee.com.common.utils.Logger;
import buykee.com.common.utils.constant.ConstTag;

/**
 * @author lsd
 * @date 2017/11/29.
 */

public class RCLayout extends BaseLayout {
    private float[] radii;   // top-left, top-right, bottom-right, bottom-left
    private Path mClipPath;                 // 剪裁区域路径
    private Paint mPaint;                   // 画笔
    private boolean mRoundAsCircle; // 是否是圆形
    private int mStrokeColor;               // 描边颜色
    private int mStrokeWidth;               // 描边半径
    private Region mAreaRegion;             // 内容区域
    private int mEdgeFix = 10;              // 边缘修复

    public RCLayout(Context context) {
        super(context);
    }

    public RCLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RCLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initAttrs(AttributeSet attrs) {
        super.initAttrs(attrs);
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.RCLayout);
        mRoundAsCircle = ta.getBoolean(R.styleable.RCLayout_round_as_circle, false);
        mStrokeColor = ta.getColor(R.styleable.RCLayout_stroke_color, Color.WHITE);
        mStrokeWidth = ta.getDimensionPixelSize(R.styleable.RCLayout_stroke_width, 0);
        int roundCorner = ta.getDimensionPixelSize(R.styleable.RCLayout_round_corner, 0);
        int roundCornerTopLeft = ta.getDimensionPixelSize(
                R.styleable.RCLayout_round_corner_top_left, roundCorner);
        int roundCornerTopRight = ta.getDimensionPixelSize(
                R.styleable.RCLayout_round_corner_top_right, roundCorner);
        int roundCornerBottomLeft = ta.getDimensionPixelSize(
                R.styleable.RCLayout_round_corner_bottom_left, roundCorner);
        int roundCornerBottomRight = ta.getDimensionPixelSize(
                R.styleable.RCLayout_round_corner_bottom_right, roundCorner);
        //        ta.recycle();

        radii = new float[8];
        radii[0] = roundCornerTopLeft;
        radii[1] = roundCornerTopLeft;

        radii[2] = roundCornerTopRight;
        radii[3] = roundCornerTopRight;

        radii[4] = roundCornerBottomRight;
        radii[5] = roundCornerBottomRight;

        radii[6] = roundCornerBottomLeft;
        radii[7] = roundCornerBottomLeft;
    }

    @Override
    public void initView() {
        mClipPath = new Path();
        mAreaRegion = new Region();//todo 不懂

        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Logger.d(ConstTag.todo, mTag, "onSizeChanged", w, h, oldw, oldh);
        super.onSizeChanged(w, h, oldw, oldh);
        RectF areas = new RectF();
        areas.left = getPaddingLeft();
        areas.top = getPaddingTop();
        areas.right = w - getPaddingRight();
        areas.bottom = h - getPaddingBottom();
        mClipPath.reset();
        if (mRoundAsCircle) {
            float d = areas.width() >= areas.height() ? areas.height() : areas.width();
            float r = d / 2;
            PointF center = new PointF(w / 2, h / 2);
            mClipPath.addCircle(center.x, center.y, r, Path.Direction.CW);
            mClipPath.moveTo(-mEdgeFix, -mEdgeFix);  // 通过空操作让Path区域占满画布
            mClipPath.moveTo(w + mEdgeFix, h + mEdgeFix);
        } else {
            mClipPath.addRoundRect(areas, radii, Path.Direction.CW);
        }
        Region clip = new Region((int) areas.left, (int) areas.top,
                                 (int) areas.right, (int) areas.bottom);
        mAreaRegion.setPath(mClipPath, clip);
    }

    /**
     * 需要理解
     * @param canvas
     */
    @Override
    protected void dispatchDraw(Canvas canvas) {
        Logger.d(ConstTag.todo, mTag, "dispatchDraw");
        canvas.saveLayer(new RectF(0, 0, canvas.getWidth(), canvas.getHeight()), null);
        super.dispatchDraw(canvas);
        if (mStrokeWidth > 0) {
            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            mPaint.setStrokeWidth(mStrokeWidth * 2);
            mPaint.setColor(mStrokeColor);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(mClipPath, mPaint);
        }
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(mClipPath, mPaint);
        canvas.restore();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //Return true if the region contains the specified point
        if (!mAreaRegion.contains((int) ev.getX(), (int) ev.getY())) {
            return false;
        }
        return super.dispatchTouchEvent(ev);
    }
}
