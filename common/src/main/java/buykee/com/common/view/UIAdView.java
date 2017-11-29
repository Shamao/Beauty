package buykee.com.common.view;

import android.content.Context;
import android.util.AttributeSet;

import buykee.com.common.R;
import buykee.com.common.base.BaseLayout;

/**
 * @author lsd
 * @date 2017/11/13.
 */

public class UIAdView extends BaseLayout {


    public UIAdView(Context context) {
        super(context);
    }

    public UIAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UIAdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getLayoutId() {
        return R.layout.widget_ad;
    }

    @Override
    public void initView() {

    }


}
