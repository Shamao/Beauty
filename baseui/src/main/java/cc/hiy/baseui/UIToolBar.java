package cc.hiy.baseui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * @author lsd
 * @date 2019/1/8.
 */
public class UIToolBar extends RelativeLayout {

    /**
     * Toolbar 左右两侧样式定义
     */
    public static class Style {
        public static final int S_ONLY_TEXT = 0; // 仅文本
        public static final int S_ONLY_IMG = 1;// 仅图片
        public static final int S_BOTH = 2;// 文本和资源图片
        public static final int S_CUSTOM = 3; // 自定义
    }

    public UIToolBar(Context context) {
        super(context);
    }

    public UIToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UIToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
