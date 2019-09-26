package cc.hiy.baseui.titlebar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import cc.hiy.baseui.R;
import cc.hiy.baseui.titlebar.provider.IViewProvider;

/**
 * 标题栏
 * <p>
 * 关于字体大小问题  xml 接受dp值， 外部传入也是dp值  get方法返回的是px
 *
 * @author lsd
 */
public class UITitleBar extends RelativeLayout {
    private static final String S_TAG = "UITitleBar";
    /**
     * 全局
     */
    private float mViewAlpha = 1.0f;
    /**
     * 左 View
     */
    protected IViewProvider mLeftViewProvider;

    /**
     * 右 View
     */
    protected IViewProvider mRightViewProvider;

    /**
     * 中 View
     */
    protected IViewProvider mCenterViewProvider;

    /**
     * 下 View
     */
    protected IViewProvider mBottomViewProvider;

    private OnTitleBarClickListener mOnTitleBarClickListener;


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
            @SuppressLint("CustomViewStyleable") final TypedArray a =
                    getContext().obtainStyledAttributes(attrs, R.styleable.UITitleBar);
            mViewAlpha = a.getFloat(R.styleable.UITitleBar_bar_bg_alpha, 1.0f);
            a.recycle();
        } catch (Exception ignored) {

        }
    }


    /**
     * 初始化入口
     */
    private void initView() {
        setViewAlpha(mViewAlpha);
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

    private void addCenterView() {
        if (mCenterViewProvider == null) {
            return;
        }
        View view = mCenterViewProvider.getView();
        view.setId(R.id.title_bar_middle_view);
        LayoutParams lp = (LayoutParams) view.getLayoutParams();
        if (lp == null) {
            lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        lp.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
        checkChildParent(view);
        addView(view, lp);
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnTitleBarClickListener != null) {
                    mOnTitleBarClickListener.onCenterClick(v);
                }
            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////
    // 左 View
    ///////////////////////////////////////////////////////////////////////////

    private void addLeftView() {
        if (mLeftViewProvider == null) {
            return;
        }
        View view = mLeftViewProvider.getView();
        view.setId(R.id.title_bar_left_view);
        LayoutParams lp = (LayoutParams) view.getLayoutParams();
        if (lp == null) {
            lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 1);
        lp.addRule(RelativeLayout.CENTER_VERTICAL, 1);
        checkChildParent(view);
        addView(view, lp);
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnTitleBarClickListener != null) {
                    mOnTitleBarClickListener.onLeftClick(v);
                }
            }
        });
    }


    ///////////////////////////////////////////////////////////////////////////
    // 右 View
    ///////////////////////////////////////////////////////////////////////////
    private void addRightView() {
        if (mRightViewProvider == null) {
            return;
        }

        View view = mRightViewProvider.getView();
        view.setId(R.id.title_bar_right_view);

        LayoutParams lp = (LayoutParams) view.getLayoutParams();
        if (lp == null) {
            lp = new LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
        }

        lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 1);
        lp.addRule(RelativeLayout.CENTER_VERTICAL, 1);
        checkChildParent(view);
        addView(view, lp);
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnTitleBarClickListener != null) {
                    mOnTitleBarClickListener.onRightClick(v);
                }
            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////
    // 下 View
    ///////////////////////////////////////////////////////////////////////////
    private void addBottomView() {
        if (mBottomViewProvider == null) {
            return;
        }

        mBottomViewProvider.getView().setId(R.id.title_bar_bottom_view);
        LayoutParams lp = (LayoutParams) mBottomViewProvider.getView().getLayoutParams();
        if (lp == null) {
            lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 1);
        addView(mBottomViewProvider.getView(), lp);
    }

    /**
     * 更新左 View样式 下面三个方法一样
     *
     * @param viewProvider
     */
    public void bindLeftViewProvider(IViewProvider viewProvider) {
        if (mLeftViewProvider != null) {
            checkChildParent(mLeftViewProvider.getView());
        }
        mLeftViewProvider = viewProvider;
        addLeftView();
    }

    public void bindRightViewProvider(IViewProvider viewProvider) {
        if (mRightViewProvider != null) {
            checkChildParent(mRightViewProvider.getView());
        }
        mRightViewProvider = viewProvider;
        addRightView();
    }

    public void bindCenterViewProvider(IViewProvider viewProvider) {
        if (mCenterViewProvider != null) {
            checkChildParent(mCenterViewProvider.getView());
        }
        mCenterViewProvider = viewProvider;
        addCenterView();
    }

    public void bindBottomViewProvider(IViewProvider viewProvider) {
        if (mBottomViewProvider != null) {
            checkChildParent(mBottomViewProvider.getView());
        }
        mBottomViewProvider = viewProvider;
        addBottomView();
    }

    /**
     * 校验当前View 是否已经在容器中， 若存在则删除  若不存在 不操作
     *
     * @param view
     */
    public void checkChildParent(View view) {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public IViewProvider getLeftViewHolder() {
        return mLeftViewProvider;
    }

    public IViewProvider getRightViewHolder() {
        return mRightViewProvider;
    }

    public IViewProvider getMiddleViewHolder() {
        return mCenterViewProvider;
    }

    public IViewProvider getBottomViewHolder() {
        return mBottomViewProvider;
    }
}
