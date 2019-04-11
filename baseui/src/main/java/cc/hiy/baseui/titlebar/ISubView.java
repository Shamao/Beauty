package cc.hiy.baseui.titlebar;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * @author lsd
 * @date 2019/4/5.
 */
public interface ISubView {

    View getView();

    void setDrawable(Drawable left, Drawable right);

    void setContent(CharSequence content);

    void setTextColor(int color);

    void setTextSize(int unit, float size);

    void setViewPadding(int left, int right);

    void setViewAlpha(float alpha);
}
