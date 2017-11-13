package beauty.louise.com.view.flexbox;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsd on 2017/10/24.
 */

public class UIFlexBoxView extends FlexboxLayout {
    private static final String mTag = UIFlexBoxView.class.getSimpleName();
    private FlexBoxAdapter<FlexBoxViewHolder> mAdapter;
    private List<FlexBoxViewHolder> mHolders;

    private AdapterDataSetObserver mDataSetObserver;
    private int mCurItemCount; // 当前数据源个数
    private int mSpanCount;



    private OnFlexBoxItemClickListener mListener;

    public UIFlexBoxView(Context context) {
        this(context, null);
    }

    public UIFlexBoxView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UIFlexBoxView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        mHolders = new ArrayList<>();
    }

    @Override
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mAdapter != null && mDataSetObserver == null) {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mCurItemCount = mAdapter.getCount();
        }
    }

    @Override
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mAdapter != null && mDataSetObserver != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            mDataSetObserver = null;
        }
    }

    public void setAdapter(FlexBoxAdapter adapter) {
        if (mAdapter != null && mDataSetObserver != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        }

        mAdapter = adapter;

        if (mAdapter != null) {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            refreshView();
        } else {
            throw new NullPointerException("adapter 不可为空");
        }
    }


    /**
     * 重新展示数据 eg:数据源==View数  或  数据源数>View数量
     */
    private void refreshView() {
        mCurItemCount = mAdapter.getCount();
        if (mCurItemCount > 0) {
            for (int i = 0; i < mCurItemCount; i++) {
                final FlexBoxViewHolder holder = createViewHolder(i);

                onHandleItmViewListener(i, holder);

                mAdapter.onHandleLayoutParams(holder.itemView, mSpanCount, i);

                mAdapter.onBindViewHolder(holder, i);
            }
        } else {
            removeAllViews();
            mHolders.clear();
        }
    }

    private void onHandleItmViewListener(int i, final FlexBoxViewHolder holder) {
        final int finalI = i;
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(holder.itemView, finalI);
                }
            }
        });
    }

    /**
     * 创建ViewHolder
     *
     * @param position
     * @return
     */
    private FlexBoxViewHolder createViewHolder(int position) {

        FlexBoxViewHolder holder = null;
        if (mHolders.size() > position) {
            holder = mHolders.get(position);
        }

        if (holder == null) {
            holder = mAdapter.onCreateViewHolder(this);
            if (holder.itemView.getParent() == null) {
                // 未添加到父布局中需要添加，已经添加的不需要再次添加
                this.addView(holder.itemView, position);
            }
            mHolders.add(holder);
        }
        return holder;
    }

    private void notifyDataChanged() {
    }

    private class AdapterDataSetObserver extends DataSetObserver {
        @Override
        public void onChanged() {
            super.onChanged();
            notifyDataChanged();
        }

        @Override
        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    public void setOnFlexBoxItemClickListener(OnFlexBoxItemClickListener listener) {
        mListener = listener;
    }

    public int getSpanCount() {
        return mSpanCount;
    }

    public void setSpanCount(int spanCount) {
        mSpanCount = spanCount;
    }
}
