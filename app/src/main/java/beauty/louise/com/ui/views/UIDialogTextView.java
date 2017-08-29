package beauty.louise.com.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import beauty.louise.com.R;


/**
 * Created by Steam on 16/12/13.
 */

public class UIDialogTextView extends LinearLayout {

    private TextView mMessageTv;

    public UIDialogTextView(Context context) {
        super(context);
        initWidget();
    }

    public UIDialogTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWidget();
    }

    private void initWidget() {
        LayoutInflater.from(getContext()).inflate(R.layout.widget_dialog_textview, this);
        mMessageTv = (TextView) findViewById(R.id.message);
    }

    public void setMessage(String message) {
        mMessageTv.setText(message);
    }
}