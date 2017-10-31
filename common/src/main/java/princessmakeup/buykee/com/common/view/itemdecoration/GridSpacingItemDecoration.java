package princessmakeup.buykee.com.common.view.itemdecoration;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lsd on 17/2/14.
 */

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int spanCount;
    private int spacingV;
    private int spacingH;
    private boolean includeEdge;
    private GridLayoutManager mLayoutManager;

    public GridSpacingItemDecoration(int spacing, boolean includeEdge) {
        this.spacingV = spacing;
        this.spacingH = spacing;
        this.includeEdge = includeEdge;
    }


    public GridSpacingItemDecoration(int spacingV, int spacingH, boolean includeEdge) {
        this.spacingV = spacingV;
        this.spacingH = spacingH;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mLayoutManager == null) {
            mLayoutManager = (GridLayoutManager) parent.getLayoutManager();
        }

        int position = parent.getChildAdapterPosition(view); // item position
        int spanCount = mLayoutManager.getSpanCount();// column counts in a row
        int spanSize = mLayoutManager.getSpanSizeLookup().getSpanSize(position);// item has many span
        int column = mLayoutManager.getSpanSizeLookup().getSpanIndex(position, spanCount);
        int totalChildCount = parent.getAdapter().getItemCount();

        boolean isFirstRow = mLayoutManager.getSpanSizeLookup().getSpanGroupIndex(position, spanCount) == 0;
        boolean isLastRow = spanSize == 1 ? position + spanCount - column > totalChildCount - 1 :
                position - column / spanSize > totalChildCount - 1;

        if (includeEdge) {
            if (spanSize == spanCount) {
                outRect.left = 0;
                outRect.top = 0;
                outRect.right = 0;
                outRect.top = 0;
            } else {
                outRect.left = column == 0 ? spacingH : spacingH / 2;//+ (1-(column / spanCount)) * spacingH;
                outRect.top = spacingV;
                outRect.right = ((column + spanSize) == spanCount) ? spacingH : spacingH / 2;
                outRect.bottom = isLastRow ? spacingV : 0; // item bottom
            }
        } else {
            outRect.left = column / spanCount * spacingH;
            outRect.right = spacingH - (column + spanSize) / spanCount * spacingH;
            outRect.top = isFirstRow ? 0 : spacingV;
        }
    }
}
