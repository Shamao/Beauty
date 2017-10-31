package princessmakeup.buykee.com.common.view.itemdecoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by lsd on 17/5/2.
 */

public class StaggeredItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private boolean isIncludeEdge;

    public StaggeredItemDecoration(int space) {
        this.space = space;
        isIncludeEdge = false;
    }

    public StaggeredItemDecoration(int space, boolean isIncludeEdge) {
        this.space = space;
        this.isIncludeEdge = isIncludeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
        int position = parent.getChildAdapterPosition(view);
        boolean isFullSpan = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).isFullSpan();
        int spanCount = ((StaggeredGridLayoutManager) parent.getLayoutManager()).getSpanCount();

        if (isIncludeEdge) {
            if (isFullSpan && position == 0) {
                outRect.top = space;
            }

            if (!isFullSpan) {
                int headCount = 0;
//                if (parent instanceof HeaderAndFooterRecyclerView) {
//                    headCount = ((HeaderAndFooterRecyclerView) parent).getHeaderViewCount();
//                }

                if (position < headCount + spanCount) {
                    outRect.top = space;
                }
            }
        }

        RecyclerView.ViewHolder holder = parent.getChildViewHolder(view);//adapter.getItemViewType(position);
//        if (holder instanceof BBSThreadViewHolder) {
            if (spanIndex == 0) {
                outRect.left = space;
                outRect.right = space / 2;
            } else {//if you just have 2 span . Or you can use (staggeredGridLayoutManager.getSpanCount()-1) as last span
                outRect.left = space / 2;
                outRect.right = space;
            }
            outRect.bottom = space;
//        }
    }
}
