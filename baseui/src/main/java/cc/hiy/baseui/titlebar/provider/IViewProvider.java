package cc.hiy.baseui.titlebar.provider;

import android.content.Context;
import android.view.View;

/**
 * @author lsd
 * @date 2019/4/5.
 */
public abstract class IViewProvider<V extends View> {

    public V view;

    public IViewProvider(Context context) {
        view = onCreateView(context);
        if (view == null) {
            throw new RuntimeException("need to new a  view object");
        }
    }

    abstract V onCreateView(Context context);


    public void setOnClickListener(final View.OnClickListener listener) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onClick(v);
                    }
                }
            });
        }
    }
}
