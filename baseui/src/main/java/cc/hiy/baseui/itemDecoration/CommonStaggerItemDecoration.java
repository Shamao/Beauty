package cc.hiy.baseui.itemDecoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.Arrays;

/**
 * @author lsd
 */
public class CommonStaggerItemDecoration extends RecyclerView.ItemDecoration {


    /**
     * if item isFullSpan = false, its bounds need to set this padding, but not include its spanIndex = 0 , spanCount -1
     */
    private int mOriginVerticalPadding;
    private int mOriginHorizontalPadding;
    private int mHeaderCount;
    private int mFooterCount;

    /**
     * if item isFullSpan = true, its bounds need to set this padding, exclude header and footer
     */
    private boolean isIncludeFullSpan;
    private int mFullSpanVerticalPadding;
    private int mFullSpanHorizontalPadding;
    private Integer[] mIncludePositions;

    /**
     * 是否含边距  和容器的边界相邻
     */
    private boolean isIncludeEdge;
    private int mEdgeVerticalPadding;
    private int mEdgeHorizontalPadding;


    public CommonStaggerItemDecoration(int originVerticalPadding, int originHorizontalPadding, int headerCount, int footerCount) {
        mOriginVerticalPadding = originVerticalPadding;
        mOriginHorizontalPadding = originHorizontalPadding;
        mHeaderCount = headerCount;
        mFooterCount = footerCount;
    }

    public CommonStaggerItemDecoration withFullSpanPadding(int fullSpanVerticalPadding, int fullSpanHorizontalPadding, Integer[] includePositions) {
        isIncludeFullSpan = true;
        mFullSpanVerticalPadding = fullSpanVerticalPadding;
        mFullSpanHorizontalPadding = fullSpanHorizontalPadding;
        mIncludePositions = includePositions;
        return this;
    }

    public CommonStaggerItemDecoration withEdgePadding(int edgeVerticalPadding, int edgeHorizontalPadding) {
        isIncludeEdge = true;
        mEdgeVerticalPadding = edgeVerticalPadding;
        mEdgeHorizontalPadding = edgeHorizontalPadding;
        return this;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        StaggeredGridLayoutManager.LayoutParams lp =
                (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        StaggeredGridLayoutManager lm = (StaggeredGridLayoutManager) parent.getLayoutManager();

        int spanIndex = lp.getSpanIndex();
        int spanCount = lm.getSpanCount();
        boolean isFullSpan = lp.isFullSpan();

        if (isFullSpan) {
            fillFullSpan(outRect, view, parent, state);
        } else {
            fillSingleSpan(outRect, view, parent, state, spanIndex, spanCount);
        }
    }


    public void fillSingleSpan(Rect outRect, View view, RecyclerView parent, RecyclerView.State state, int spanIndex, int spanCount) {
        int position = parent.getChildAdapterPosition(view);
        if (isIncludeEdge) {
            outRect.top = position < mHeaderCount + spanCount ? mEdgeVerticalPadding : mOriginVerticalPadding / 2;
            outRect.bottom = (position > parent.getAdapter().getItemCount() - mFooterCount - spanCount) ?
                    mEdgeVerticalPadding : mOriginHorizontalPadding / 2;
            outRect.left = spanIndex == 0 ? mEdgeHorizontalPadding : mOriginHorizontalPadding / 2;
            outRect.right = spanIndex == spanCount - 1 ? mEdgeHorizontalPadding : mOriginHorizontalPadding / 2;

        } else {
            outRect.top = position < mHeaderCount + spanCount ? 0 : mOriginVerticalPadding / 2;
            outRect.bottom = (position >= parent.getAdapter().getItemCount() - mFooterCount - spanCount) ?
                    0 : mOriginHorizontalPadding / 2;
            outRect.left = spanIndex == 0 ? 0 : mOriginHorizontalPadding / 2;
            outRect.right = spanIndex == spanCount - 1 ? mOriginHorizontalPadding : mOriginHorizontalPadding / 2;
        }
    }

    public void fillFullSpan(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (isIncludeFullSpan) {
            int position = parent.getChildAdapterPosition(view);
            int itemCount = parent.getAdapter().getItemCount();
            if (Arrays.asList(mIncludePositions).contains(position)) {
                outRect.left = mFullSpanHorizontalPadding;
                outRect.right = mFullSpanHorizontalPadding;
                outRect.top = position == 0 ? mFullSpanVerticalPadding : mFullSpanVerticalPadding / 2;
                outRect.bottom = position == itemCount - 1 ? mFullSpanVerticalPadding : mFullSpanVerticalPadding / 2;
            }
        }
    }


}
