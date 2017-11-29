package buykee.com.lab.view;

import android.content.Context;
import android.util.AttributeSet;

import buykee.com.common.base.BaseLayout;

/**
 * @author lsd
 * @date 2017/11/16.
 */

public class UITouchViewGroup extends BaseLayout {
    public UITouchViewGroup(Context context) {
        super(context);
    }

    public UITouchViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UITouchViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initView() {

    }
}
