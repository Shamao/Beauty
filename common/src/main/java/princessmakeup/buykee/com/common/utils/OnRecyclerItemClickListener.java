package princessmakeup.buykee.com.common.utils;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lsd on 17/7/27.
 */

public class OnRecyclerItemClickListener extends RecyclerView.SimpleOnItemTouchListener {
    private OnItemClickListener mListener;
    private GestureDetectorCompat gestureDetector;

    public OnRecyclerItemClickListener(final RecyclerView recyclerView,
                                        OnItemClickListener listener) {
        mListener = listener;
        this.gestureDetector = new GestureDetectorCompat(
                recyclerView.getContext(),
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        View childView = recyclerView
                                .findChildViewUnder(e.getX(), e.getY());
                        if (childView != null && mListener != null) {
                            mListener.onItemLongClick(childView,
                                                      recyclerView.getChildAdapterPosition(childView));
                        }
                    }
                });
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && gestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, rv.getChildAdapterPosition(childView));
        }
        return false;
    }

    public interface OnItemClickListener {

        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

}
