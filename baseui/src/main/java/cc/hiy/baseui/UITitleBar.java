package cc.hiy.baseui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import cc.hiy.baseui.titlebar.CommonSubView;
import cc.hiy.baseui.titlebar.ISubView;
import cc.hiy.baseui.titlebar.ITitleBarConst;

/**
 * 标题栏
 * <p>
 * 关于字体大小问题  xml 接受dp值， 外部传入也是dp值  get方法返回的是px
 *
 * @author lsd
 */
public class UITitleBar extends RelativeLayout {
    private static final String S_TAG = "UITitleBar";
    public static final int S_LEFT_FLAG = 0b100;
    public static final int S_TITLE_FLAG = 0b010;
    public static final int S_RIGHT_FLAG = 0b001;
    /**
     * 全局
     */
    private int mViewFlag = 0b000;
    private float mViewAlpha = 1.0f;
    /**
     * 左边
     */
    private ISubView mLeftView;
    private float mLeftAlpha;
    private int mLeftPadding;
    private CharSequence mLeftText;
    private int mLeftTextSize;
    private int mLeftTextColor;
    private Drawable mLeftDraw;
    /**
     * 右边
     */
    private ISubView mRightView;
    private float mRightAlpha;
    private int mRightPadding;
    private CharSequence mRightText;
    private int mRightTextSize;
    private int mRightTextColor;
    private Drawable mRightDraw;
    /**
     * 标题
     */
    private ISubView mTitleView;
    private CharSequence mTitle;
    private float mTitleAlpha;
    private int mTitleTextSize;
    private int mTitleTextColor;


    public UITitleBar(Context context) {
        this(context, null);

    }

    public UITitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UITitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(attrs);
        initView();
    }

    private void initAttr(AttributeSet attrs) {
        try {
            final TypedArray a = getContext().obtainStyledAttributes(
                    attrs, R.styleable.UITitleBar);
            mViewAlpha = a.getFloat(R.styleable.UITitleBar_bar_bg_alpha, 1.0f);

            mLeftAlpha = a.getFloat(R.styleable.UITitleBar_bar_left_view_alpha, 1.0f);
            mLeftPadding = (int) a.getDimension(R.styleable.UITitleBar_bar_left_padding, TypedValue
                    .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics()));
            mLeftText = a.getString(R.styleable.UITitleBar_bar_left_text);
            mLeftTextSize = (int) a.getDimension(R.styleable.UITitleBar_bar_left_text_size, TypedValue
                    .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()));
            mLeftTextColor = a.getColor(R.styleable.UITitleBar_bar_left_text_color, ITitleBarConst.S_COLOR_BLACK);
            mLeftDraw = a.getDrawable(R.styleable.UITitleBar_bar_left_src);

            mRightAlpha = a.getFloat(R.styleable.UITitleBar_bar_right_view_alpha, 1.0f);
            mRightPadding = (int) a.getDimension(R.styleable.UITitleBar_bar_right_padding, TypedValue
                    .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics()));
            mRightText = a.getString(R.styleable.UITitleBar_bar_right_text);
            mRightTextSize = (int) a.getDimension(R.styleable.UITitleBar_bar_right_text_size, TypedValue
                    .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()));
            mRightTextColor = a.getColor(R.styleable.UITitleBar_bar_right_text_color, ITitleBarConst.S_COLOR_BLACK);
            mRightDraw = a.getDrawable(R.styleable.UITitleBar_bar_right_src);

            mTitleAlpha = a.getFloat(R.styleable.UITitleBar_bar_title_view_alpha, 1.0f);
            mTitle = a.getString(R.styleable.UITitleBar_bar_title_text);
            mTitleTextSize = (int) a.getDimension(R.styleable.UITitleBar_bar_title_text_size, TypedValue
                    .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()));
            mTitleTextColor = a.getColor(R.styleable.UITitleBar_bar_title_text_color, ITitleBarConst.S_COLOR_BLACK);

            int leftFlag = a.getInteger(R.styleable.UITitleBar_bar_left_switch, 1);
            int rightFlag = a.getInteger(R.styleable.UITitleBar_bar_right_switch, 1);
            int titleFlag = a.getInteger(R.styleable.UITitleBar_bar_title_switch, 1);
            mViewFlag = (leftFlag << 2) | ((titleFlag << 1) | rightFlag);

            a.recycle();
        } catch (Exception e) {

        }
    }

    /**
     * 是否需要初始化左View
     *
     * @return
     */
    public boolean isNeedInitLeftView() {
        return (mViewFlag & S_LEFT_FLAG) > 0;
    }

    /**
     * 是否需要初始化title View
     *
     * @return
     */
    public boolean isNeedInitTitleView() {
        return (mViewFlag & S_TITLE_FLAG) > 0;
    }

    /**
     * 是否需要初始化左View
     *
     * @return
     */
    public boolean isNeedInitRightView() {
        return (mViewFlag & S_RIGHT_FLAG) > 0;
    }

    /**
     * 初始化入口
     */
    private void initView() {
        setViewAlpha(mViewAlpha);

        if (isNeedInitLeftView()) {
            initLeftView();
        }

        if (isNeedInitRightView()) {
            initRightView();
        }

        if (isNeedInitTitleView()) {
            initTitleView();
        }
    }

    public void setViewAlpha(float alpha) {
        mViewAlpha = alpha;

        Drawable drawable = getBackground();
        if (drawable != null) {
            drawable.setAlpha((int) (alpha * 255));
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // left View
    ///////////////////////////////////////////////////////////////////////////

    private void initLeftView() {
        mLeftView = new CommonSubView(getContext());
        ((CommonSubView) mLeftView).setId(R.id.title_bar_left_view);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 1);
        addView(mLeftView.getView(), lp);

        setLeftAlpha(mLeftAlpha);
        setLeftSrc(mLeftDraw);
        setLeftText(mLeftText);
        setLeftTextSize(TypedValue.COMPLEX_UNIT_PX, mLeftTextSize);
        setLeftTextColor(mLeftTextColor);
        setLeftPadding(mLeftPadding);
    }

    public void setLeftSrc(Drawable drawable) {
        if (mLeftView == null || mLeftView.getView() == null) {
            return;
        }

        mLeftDraw = drawable;
        mLeftView.setDrawable(drawable, null);
    }

    public void setLeftText(CharSequence content) {
        if (mLeftView == null || mLeftView.getView() == null) {
            return;
        }

        mLeftText = content;
        mLeftView.setContent(content);
    }

    public void setLeftTextSize(int unit, int size) {
        if (mLeftView == null || mLeftView.getView() == null) {
            return;
        }

        mLeftTextSize = (int) TypedValue.applyDimension(unit, size, getResources().getDisplayMetrics());
        mLeftView.setTextSize(unit, size);
    }

    public void setLeftTextColor(int color) {
        if (mLeftView == null || mLeftView.getView() == null) {
            return;
        }

        mLeftTextColor = color;
        mLeftView.setTextColor(color);
    }

    public void setLeftPadding(int padding) {
        if (mLeftView == null || mLeftView.getView() == null) {
            return;
        }

        mLeftPadding = padding;
        mLeftView.setViewPadding(padding, 0);
    }

    public void setLeftAlpha(float alpha) {
        if (mLeftView == null || mLeftView.getView() == null) {
            return;
        }

        mLeftAlpha = alpha;
        mLeftView.setViewAlpha(alpha);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 右边View
    ///////////////////////////////////////////////////////////////////////////

    private void initRightView() {
        mRightView = new CommonSubView(getContext());
        ((CommonSubView) mRightView).setId(R.id.title_bar_right_view);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 1);
        addView(mRightView.getView(), lp);

        setRightPadding(mRightPadding);
        setRightAlpha(mRightAlpha);
        setRightText(mRightText);
        setRightTextSize(TypedValue.COMPLEX_UNIT_PX, mRightTextSize);
        setRightTextColor(mRightTextColor);
        setRightSrc(mRightDraw);
    }

    public void setRightPadding(int padding) {
        if (mRightView == null || mRightView.getView() == null) {
            return;
        }
        mRightPadding = padding;
        mRightView.setViewPadding(0, padding);
    }

    public void setRightText(CharSequence content) {
        if (mRightView == null || mRightView.getView() == null) {
            return;
        }

        mRightText = content;
        mRightView.setContent(content);
    }

    public void setRightSrc(Drawable drawable) {
        if (mRightView == null || mRightView.getView() == null) {
            return;
        }
        mRightDraw = drawable;
        mRightView.setDrawable(null, drawable);
    }

    public void setRightTextSize(int unit, int rightTextSize) {
        if (mRightView == null || mRightView.getView() == null) {
            return;
        }
        mRightTextSize = (int) TypedValue.applyDimension(unit, rightTextSize, getResources().getDisplayMetrics());
        mRightView.setTextSize(unit, rightTextSize);
    }


    public void setRightTextColor(int rightTextColor) {
        if (mRightView == null || mRightView.getView() == null) {
            return;
        }

        mRightTextColor = rightTextColor;
        mRightView.setTextColor(rightTextColor);

    }

    public void setRightAlpha(float alpha) {
        if (mRightView == null || mRightView.getView() == null) {
            return;
        }
        mRightAlpha = alpha;
        mRightView.setViewAlpha(alpha);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 标题栏
    ///////////////////////////////////////////////////////////////////////////
    private void initTitleView() {
        mTitleView = new CommonSubView(getContext());
        ((CommonSubView) mTitleView).setId(R.id.title_bar_title_view);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
        //        lp.addRule(RelativeLayout.RIGHT_OF, R.id.title_bar_left_view);
        //        lp.addRule(RelativeLayout.LEFT_OF, R.id.title_bar_right_view);
        addView(mTitleView.getView(), lp);

        setTitleAlpha(mTitleAlpha);
        setTitle(mTitle);
        setTitleTextColor(mTitleTextColor);
        setTitleTextSize(TypedValue.COMPLEX_UNIT_PX, mTitleTextSize);
    }


    public void setTitle(CharSequence charSequence) {
        if (mTitleView == null || mTitleView.getView() == null) {
            return;
        }

        mTitle = charSequence;
        mTitleView.setContent(charSequence);
    }

    public void setTitleTextColor(int titleColor) {
        if (mTitleView == null || mTitleView.getView() == null) {
            return;
        }

        mTitleTextColor = titleColor;
        mTitleView.setTextColor(titleColor);
    }

    public void setTitleTextSize(int unit, int titleTextSize) {
        if (mTitleView == null || mTitleView.getView() == null) {
            return;
        }

        mTitleTextSize = (int) TypedValue.applyDimension(unit, mTitleTextSize, getResources().getDisplayMetrics());
        mTitleView.setTextSize(unit, titleTextSize);
    }

    public void setTitleAlpha(float alpha) {
        if (mTitleView == null || mTitleView.getView() == null) {
            return;
        }

        mTitleAlpha = alpha;
        mTitleView.setViewAlpha(alpha);
    }

    ///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    ///////////////////////////////////////////////////////////////////////////
    // get
    ///////////////////////////////////////////////////////////////////////////


    public int getViewFlag() {
        return mViewFlag;
    }

    public float getViewAlpha() {
        return mViewAlpha;
    }

    public ISubView getLeftView() {
        return mLeftView;
    }

    public float getLeftAlpha() {
        return mLeftAlpha;
    }

    public int getLeftPadding() {
        return mLeftPadding;
    }

    public CharSequence getLeftText() {
        return mLeftText;
    }

    public int getLeftTextSize() {
        return mLeftTextSize;
    }

    public int getLeftTextColor() {
        return mLeftTextColor;
    }

    public Drawable getLeftDraw() {
        return mLeftDraw;
    }

    public ISubView getRightView() {
        return mRightView;
    }

    public float getRightAlpha() {
        return mRightAlpha;
    }

    public int getRightPadding() {
        return mRightPadding;
    }

    public CharSequence getRightText() {
        return mRightText;
    }

    public int getRightTextSize() {
        return mRightTextSize;
    }

    public int getRightTextColor() {
        return mRightTextColor;
    }

    public Drawable getRightDraw() {
        return mRightDraw;
    }

    public ISubView getTitleView() {
        return mTitleView;
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public float getTitleAlpha() {
        return mTitleAlpha;
    }

    public int getTitleTextSize() {
        return mTitleTextSize;
    }

    public int getTitleTextColor() {
        return mTitleTextColor;
    }
}
