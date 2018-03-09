package com.louise.base.view;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lsd
 */

public class test extends RecyclerView.ItemDecoration {

    /**
     * 方向
     */
    private int mOrientation;

    /**
     * 原本方向上的边距
     * eg:  if orientation is vertical， the spacing only include top and bottom
     * position = 0 without top and position = getItemCount() - 1 without bottom
     */
    private int mOriginPadding;
    /**
     * 是否含边距  和容器的边界相邻
     */
    private boolean isIncludeEdge;
    /**
     * 垂直方向上的间距
     */
    private int mVerticalEdgePadding;
    /**
     * 水平方向上的间距
     */
    private int mHorizontalEdgePadding;

    public test(int originPadding, int orientation) {
        mOriginPadding = originPadding;
        mOrientation = orientation;
    }

    public test withEdge(int verticalEdgePadding, int horizontalEdgePadding) {
        isIncludeEdge = true;
        mVerticalEdgePadding = verticalEdgePadding;
        mHorizontalEdgePadding = horizontalEdgePadding;
        return this;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == LinearLayoutManager.VERTICAL) {
            fillVertical(outRect, view, parent, state);
        } else {
            fillHorizontal(outRect, view, parent, state);
        }
    }

    public void fillVertical(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int itemCount = parent.getAdapter().getItemCount();

        outRect.top = position == 0 ? 0 : mOriginPadding / 2;
        outRect.bottom = position == itemCount - 1 ? 0 : mOriginPadding / 2;

        if (isIncludeEdge) {
            outRect.left = mHorizontalEdgePadding;
            outRect.right = mHorizontalEdgePadding;
            if (position == 0) {
                outRect.top = mVerticalEdgePadding;
            }

            if (position == itemCount - 1) {
                outRect.bottom = mVerticalEdgePadding;
            }
        }
    }

    public void fillHorizontal(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int itemCount = parent.getAdapter().getItemCount();

        outRect.left = position == 0 ? 0 : mOriginPadding / 2;
        outRect.right = position == itemCount - 1 ? 0 : mOriginPadding / 2;

        if (isIncludeEdge) {
            outRect.top = mVerticalEdgePadding;
            outRect.bottom = mVerticalEdgePadding;
            if (position == 0) {
                outRect.left = mVerticalEdgePadding;
            }

            if (position == itemCount - 1) {
                outRect.right= mVerticalEdgePadding;
            }
        }
    }

}