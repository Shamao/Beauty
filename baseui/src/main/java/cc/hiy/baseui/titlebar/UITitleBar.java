package cc.hiy.baseui.titlebar;

import android.content.Context;
import android.util.AttributeSet;

import cc.hiy.baseui.titlebar.provider.DividerViewProvider;
import cc.hiy.baseui.titlebar.provider.IViewProvider;
import cc.hiy.baseui.titlebar.provider.TextDrawViewProvider;
import cc.hiy.baseui.titlebar.provider.TitleViewProvider;
import cc.hiy.baseui.titlebar.utils.Location;

/**
 * 标题栏
 * <p>
 * 关于字体大小问题  xml 接受dp值， 外部传入也是dp值  get方法返回的是px
 *
 * @author lsd
 */
public class UITitleBar extends UIBaseTitleBar {

    public UITitleBar(Context context) {
        super(context);
    }

    public UITitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UITitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public IViewProvider onCreateViewHolder(int type) {
        switch (type) {
            case Location.CENTER:
                return new TitleViewProvider(getContext());
            case Location.LEFT:
            case Location.RIGHT:
                return new TextDrawViewProvider(getContext());
            case Location.BOTTOM:
                return new DividerViewProvider(getContext());
        }
        return null;
    }


}
