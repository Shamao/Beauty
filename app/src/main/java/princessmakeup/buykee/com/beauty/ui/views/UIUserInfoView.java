package princessmakeup.buykee.com.beauty.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import princessmakeup.buykee.com.beauty.R;

/**
 * Created by lsd on 17/1/23.
 */

public class UIUserInfoView extends FrameLayout {

    public UIUserInfoView(Context context) {
        this(context, null);
    }

    public UIUserInfoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UIUserInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.header_user_info, this);
    }
}
