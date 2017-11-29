package beauty.louise.com.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.FloatRange;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import beauty.louise.com.R;
import butterknife.BindView;
import butterknife.OnClick;
import buykee.com.common.base.BaseLayout;

/**
 * Created by lsd on 17/5/8.
 */

public class UIGradientTopBar extends BaseLayout {
    @BindView(R.id.left_layout)
    View mLeftView;
    @BindView(R.id.left_iv)
    ImageView mLeftIv;
    @BindView(R.id.right_layout)
    View mRightView;
    @BindView(R.id.right_iv)
    ImageView mRightIv;
    @BindView(R.id.title_tv)
    TextView mTitleTv;
    @BindView(R.id.bg_view)
    View mBgView;

    private Drawable mLeftDraw;
    private Drawable mRightDraw;
    private String mTitle;
    private int mTitleSize;
    private int mTitleColor;
    private float mBgAlpha;


    public UIGradientTopBar(Context context) {
        super(context);
    }

    public UIGradientTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UIGradientTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getLayoutId() {
        return R.layout.widget_bbs_top_bar;
    }

    @Override
    public void initAttrs(AttributeSet attrs) {
        super.initAttrs(attrs);
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.UIGradientTopBar, 0, 0);
        mLeftDraw = array.getDrawable(R.styleable.UIGradientTopBar_bbs_left_src);
        mRightDraw = array.getDrawable(R.styleable.UIGradientTopBar_bbs_right_src);
        mTitle = array.getString(R.styleable.UIGradientTopBar_bbs_title);
        mTitleSize = (int) array.getDimension(R.styleable.UIGradientTopBar_bbs_title_size, TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getContext().getResources().getDisplayMetrics()));
        mTitleColor = array.getColor(R.styleable.UIGradientTopBar_bbs_title_color,
                                     getResources().getColor(R.color.default_black));
        mBgAlpha = array.getFloat(R.styleable.UIGradientTopBar_bbs_bg_alpha, 1.0f);
        array.recycle();
    }

    @Override
    public void initView() {
        setLeftDraw(mLeftDraw);
        setRightDraw(mRightDraw);
        setTitle(mTitle);
        setTitleColor(mTitleColor);
        setTitleSize(TypedValue.COMPLEX_UNIT_PX, mTitleSize);
        setBgAlpha(mBgAlpha);

    }


    @OnClick(R.id.left_iv)
    void onLeftClick(View view) {
        if (mListener != null) {
            mListener.onLeftClick(view);
        }
    }

    @OnClick(R.id.right_iv)
    void onRightClick(View view) {
        if (mListener != null) {
            mListener.onRightClick(view);
        }
    }

    public void setOnTopBarClickListener(OnTopBarClickListener listener) {
        mListener = listener;
    }

    public interface OnTopBarClickListener {
        void onLeftClick(View view);

        void onRightClick(View view);
    }

    public void setLeftDraw(Drawable drawable) {
        mLeftIv.setImageDrawable(drawable);
    }


    public void setRightDraw(Drawable drawable) {
        mRightIv.setImageDrawable(drawable);
    }

    public void setTitleSize(int textSize) {
        mTitleTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
    }

    public void setTitleSize(int unit, int textSize) {
        mTitleTv.setTextSize(unit, textSize);
    }

    public void setTitleColor(int color) {
        mTitleTv.setTextColor(color);
    }

    public void setTitle(String title) {
        mTitleTv.setText(title);
    }

    public void setTitleGravity(int gravity) {
        mTitleTv.setGravity(gravity);
    }

    public void setRightSelected(boolean isSelected) {
        mRightIv.setSelected(isSelected);
    }

    private OnTopBarClickListener mListener;


    public void setBgAlpha(@FloatRange(from = 0.0, to = 1.0) float alpha) {
        mBgView.setAlpha(alpha);
        mTitleTv.setAlpha(alpha);
    }

    public void setBgColor(int colorRes) {
        mBgView.setBackgroundResource(colorRes);
    }


}
