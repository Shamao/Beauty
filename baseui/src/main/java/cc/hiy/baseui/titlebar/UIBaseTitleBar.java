package cc.hiy.baseui.titlebar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import cc.hiy.baseui.R;
import cc.hiy.baseui.titlebar.provider.IViewProvider;
import cc.hiy.baseui.titlebar.utils.Location;

/**
 * 标题栏
 * <p>
 * 关于字体大小问题  xml 接受dp值， 外部传入也是dp值  get方法返回的是px
 *
 * @author lsd
 */
public abstract class UIBaseTitleBar extends RelativeLayout implements IUITitleBar {
    private static final String S_TAG = "UITitleBar";
    /**
     * 全局
     */
    private float mViewAlpha = 1.0f;
    /**
     * 左 View
     */
    protected IViewProvider mLeftViewHolder;

    /**
     * 右 View
     */
    protected IViewProvider mRightViewHolder;

    /**
     * 中 View
     */
    protected IViewProvider mMiddleViewHolder;

    /**
     * 上 View
     */
    protected IViewProvider mTopViewHolder;

    /**
     * 下 View
     */
    protected IViewProvider mBottomViewHolder;


    public UIBaseTitleBar(Context context) {
        this(context, null);

    }

    public UIBaseTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UIBaseTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(attrs);
        initView();
    }

    private void initAttr(AttributeSet attrs) {
        try {
            @SuppressLint("CustomViewStyleable") final TypedArray a =
                    getContext().obtainStyledAttributes(attrs, R.styleable.UITitleBar);
            mViewAlpha = a.getFloat(R.styleable.UITitleBar_bar_bg_alpha, 1.0f);
            a.recycle();
        } catch (Exception e) {

        }
    }


    /**
     * 初始化入口
     */
    private void initView() {
        setViewAlpha(mViewAlpha);

        initLeftView();

        initRightView();

        initMiddleView();

        initTopView();

        initBottomView();
    }

    public void setViewAlpha(float alpha) {
        mViewAlpha = alpha;

        Drawable drawable = getBackground();
        if (drawable != null) {
            drawable.setAlpha((int) (alpha * 255));
        }
    }


    ///////////////////////////////////////////////////////////////////////////
    // 中 View
    ///////////////////////////////////////////////////////////////////////////
    private void initMiddleView() {
        mMiddleViewHolder = onCreateViewHolder(Location.CENTER);
        if (mMiddleViewHolder == null) {
            return;
        }
        mMiddleViewHolder.setId(R.id.title_bar_middle_view);
        LayoutParams lp = (LayoutParams) mMiddleViewHolder.view.getLayoutParams();
        if (lp == null) {
            lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        lp.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
        addView(mMiddleViewHolder.view, lp);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 左 View
    ///////////////////////////////////////////////////////////////////////////

    private void initLeftView() {
        mLeftViewHolder = onCreateViewHolder(Location.LEFT);
        if (mLeftViewHolder == null) {
            return;
        }

        mLeftViewHolder.setId(R.id.title_bar_left_view);
        LayoutParams lp = (LayoutParams) mLeftViewHolder.view.getLayoutParams();
        if (lp == null) {
            lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 1);
        addView(mLeftViewHolder.view, lp);
    }


    ///////////////////////////////////////////////////////////////////////////
    // 右 View
    ///////////////////////////////////////////////////////////////////////////

    private void initRightView() {
        mRightViewHolder = onCreateViewHolder(Location.RIGHT);
        if (mRightViewHolder == null) {
            return;
        }

        mRightViewHolder.setId(R.id.title_bar_right_view);

        LayoutParams lp = (LayoutParams) mRightViewHolder.view.getLayoutParams();
        if (lp == null) {
            lp = new LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
        }

        lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 1);
        addView(mRightViewHolder.view, lp);
    }


    ///////////////////////////////////////////////////////////////////////////
    // 上 View
    ///////////////////////////////////////////////////////////////////////////
    private void initTopView() {
        mTopViewHolder = onCreateViewHolder(Location.TOP);
        if (mTopViewHolder == null) {
            return;
        }

        mTopViewHolder.setId(R.id.title_bar_top_view);
        LayoutParams lp = (LayoutParams) mTopViewHolder.view.getLayoutParams();
        if (lp == null) {
            lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        lp.addRule(RelativeLayout.ALIGN_PARENT_TOP, 1);
        addView(mTopViewHolder.view, lp);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 下 View
    ///////////////////////////////////////////////////////////////////////////
    private void initBottomView() {
        mBottomViewHolder = onCreateViewHolder(Location.BOTTOM);
        if (mBottomViewHolder == null) {
            return;
        }
        mBottomViewHolder.setId(R.id.title_bar_bottom_view);
        LayoutParams lp = (LayoutParams) mBottomViewHolder.view.getLayoutParams();
        if (lp == null) {
            lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 1);
        addView(mBottomViewHolder.view, lp);
    }

    public IViewProvider getLeftViewHolder() {
        return mLeftViewHolder;
    }

    public IViewProvider getRightViewHolder() {
        return mRightViewHolder;
    }

    public IViewProvider getMiddleViewHolder() {
        return mMiddleViewHolder;
    }

    public IViewProvider getTopViewHolder() {
        return mTopViewHolder;
    }

    public IViewProvider getBottomViewHolder() {
        return mBottomViewHolder;
    }
}
