package cc.hiy.baseui.titlebar.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.view.Gravity;
import android.widget.TextView;

/**
 * 标题辣 样式
 *
 * @author lsd
 * @date 2019/4/5.
 */
@SuppressLint("AppCompatCustomView")
public class TitleViewProvider extends IViewProvider<TextView> {
    @ColorInt
    public static final  int COLOR_333 = 0xFF333333;
    public static final  int DP_16 = 16;

    public TitleViewProvider(Context context) {
        super(context);
    }

    @Override
    TextView onCreateView(Context context) {
        TextView tv = new TextView(context);
        tv.setTextSize(DP_16);
        tv.setTextColor(COLOR_333);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }


    public void setText(CharSequence charSequence) {
        view.setText(charSequence);
    }

    public void setTextSize(int dp) {
        view.setTextSize(dp);
    }

    public void setTextColor(int color) {
        view.setTextColor(color);
    }
}
