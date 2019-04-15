package cc.hiy.baseui.titlebar.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

/**
 * 正常左右两侧 文本 + img 的样式
 *
 * @author lsd
 * @date 2019/4/5.
 */
@SuppressLint("AppCompatCustomView")
public class TextDrawViewProvider extends IViewProvider<TextView> {

    public TextDrawViewProvider(Context context) {
        super(context);
    }

    @Override
    TextView onCreateView(Context context) {
        TextView tv = new TextView(context);
        Log.d("UITitleBar", (tv.getLayoutParams() == null) + "" );
        tv.setGravity(Gravity.CENTER);
        return tv;
    }



    public void setText(CharSequence charSequence) {
        view.setText(charSequence);
    }

    public void setDraw(Drawable left, Drawable right) {
        view.setCompoundDrawablesRelative(left, null, right, null);
    }

    public void setTextSize(int dp) {
        view.setTextSize(dp);
    }

    public void setTextColor(int color) {
        view.setTextColor(color);
    }
}
