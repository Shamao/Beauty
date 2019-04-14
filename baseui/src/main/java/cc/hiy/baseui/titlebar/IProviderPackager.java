package cc.hiy.baseui.titlebar;

import android.content.Context;

import cc.hiy.baseui.titlebar.provider.IViewProvider;
import cc.hiy.baseui.titlebar.provider.TextDrawViewProvider;

/**
 * @author lsd
 * @date 2019/4/14.
 */
public class IProviderPackager {

    IViewProvider createProvider(Context context, int type) {
        return new TextDrawViewProvider(context);
    }
}
