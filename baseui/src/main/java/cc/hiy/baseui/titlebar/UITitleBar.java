package cc.hiy.baseui.titlebar;

import android.content.Context;
import android.util.AttributeSet;

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
}
