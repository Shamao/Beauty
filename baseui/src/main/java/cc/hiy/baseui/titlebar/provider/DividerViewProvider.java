package cc.hiy.baseui.titlebar.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * @author lsd
 * @date 2019/4/5.
 */
@SuppressLint("AppCompatCustomView")
public class DividerViewProvider extends IViewProvider<View> {

    public DividerViewProvider(Context context) {
        super(context);
    }

    @Override
    View onCreateView(Context context) {
        View tv = new View(context);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 10);
        tv.setLayoutParams(lp);
        tv.setBackgroundColor(Color.BLACK);
        return tv;
    }
}
