package cc.hiy.baseui.flexbox;

import android.view.View;

/**
 *
 * @author lsd
 * @date 2017/10/25
 */

public interface OnFlexBoxItemClickListener {
    void onItemClick(View view, int position);

    void onItemLongClick(View view, int position);
}
