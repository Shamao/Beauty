package cc.hiy.baseui.titlebar;

import android.content.Context;
import android.view.View;

import cc.hiy.baseui.R;
import cc.hiy.baseui.titlebar.provider.DividerViewProvider;
import cc.hiy.baseui.titlebar.provider.ImageViewProvider;
import cc.hiy.baseui.titlebar.provider.TitleViewProvider;

public class UITitleDelegate {


    public ImageViewProvider bindLeftBack(Context context, UITitleBar titleBar, final View.OnClickListener listener) {
        ImageViewProvider provider = new ImageViewProvider(context);
        provider.setImageResource(R.drawable.ic_blue);
        titleBar.bindLeftViewProvider(provider);
        provider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v);
                }
            }
        });
        return provider;
    }

    public TitleViewProvider bindTitle(Context context, UITitleBar titleBar, String title) {
        TitleViewProvider provider = new TitleViewProvider(context);
        provider.setText(title);
        titleBar.bindCenterViewProvider(provider);
        return provider;
    }

    public ImageViewProvider bindRightImage(Context context, UITitleBar titleBar, int resId, final View.OnClickListener listener) {
        ImageViewProvider provider = new ImageViewProvider(context);
        provider.setImageResource(resId);
        titleBar.bindRightViewProvider(provider);
        provider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v);
                }
            }
        });
        return provider;
    }

    public DividerViewProvider bindDivider(Context context, UITitleBar titleBar) {
        DividerViewProvider provider = new DividerViewProvider(context);
        titleBar.bindBottomViewProvider(provider);
        return provider;
    }
}
