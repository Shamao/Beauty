package princessmakeup.buykee.com.beauty.Utils.tools;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import princessmakeup.buykee.com.beauty.Utils.DisplayUtils;

/**
 * Created by lsd on 17/5/16.
 */

public class ToolItemDecoration extends RecyclerView.ItemDecoration {


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        int count = parent.getAdapter().getItemCount();
        if (position < count) {
            outRect.bottom = DisplayUtils.dp2px(parent.getContext(), 10);
        }
    }
}
