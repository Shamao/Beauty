package cc.hiy.baseui.titlebar;

import cc.hiy.baseui.titlebar.provider.IViewProvider;

/**
 * @author lsd
 * @date 2019/4/13.
 */
public interface IUITitleBar {

    IViewProvider onCreateViewHolder(int type);
}
