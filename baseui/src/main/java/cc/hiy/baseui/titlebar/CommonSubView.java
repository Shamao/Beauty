package cc.hiy.baseui.titlebar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * @author lsd
 * @date 2019/4/5.
 */
@SuppressLint("AppCompatCustomView")
public class CommonSubView extends TextView implements ISubView {

    public CommonSubView(Context context) {
        super(context);
        init();
    }

    public CommonSubView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CommonSubView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setGravity(Gravity.CENTER);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setDrawable(Drawable left, Drawable right) {
        setCompoundDrawablesWithIntrinsicBounds(left, null, right, null);
    }

    @Override
    public void setContent(CharSequence content) {
        setText(content);
    }


    @Override
    public void setTextColor(int color) {
        super.setTextColor(color);
    }

    @Override
    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
    }

    public void setViewPadding(int left, int right) {
        setPadding(left, 0, right, 0);
    }

    @Override
    public void setViewAlpha(float alpha) {
        setAlpha(alpha);
    }
}
