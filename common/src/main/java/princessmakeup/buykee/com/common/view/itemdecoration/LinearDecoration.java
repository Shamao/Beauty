package princessmakeup.buykee.com.common.view.itemdecoration;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Steam on 2017/2/20.
 */

public class LinearDecoration extends RecyclerView.ItemDecoration {

    private int mSpacing;
    private int mOrientation;
    private boolean mIncludeEdge;

    public LinearDecoration(int spacing, int orientation, boolean isIncludeEdge) {
        this.mSpacing = spacing;
        mOrientation = orientation;
        mIncludeEdge = isIncludeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position

        if (mOrientation == LinearLayoutManager.VERTICAL) {

            outRect.top = mSpacing;
            if (position == parent.getAdapter().getItemCount() - 1) {
                outRect.bottom = mSpacing;
            }

            if (mIncludeEdge) {
                outRect.left = mSpacing;
                outRect.right = mSpacing;
            }

        } else {

            outRect.left = mSpacing;

            if (mIncludeEdge) {
                outRect.top = mSpacing;
                outRect.bottom = mSpacing;
            }

            if (position == parent.getAdapter().getItemCount() - 1) {
                outRect.right = mSpacing;
            }
        }
    }
}
