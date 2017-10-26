package beauty.louise.com.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.flexbox.FlexboxLayout;

import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.bean.MFuncBean;
import beauty.louise.com.view.flexbox.FlexBoxAdapter;
import beauty.louise.com.view.flexbox.FlexBoxViewHolder;

/**
 * Created by lsd on 2017/10/25.
 */

public class FuncAdapter extends FlexBoxAdapter<FuncAdapter.FuncFlexBoxViewHolder> {
    List<MFuncBean> mData;


    public FuncAdapter(List<MFuncBean> data) {
        mData = data;
    }

    @Override
    public FuncFlexBoxViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_func, parent, false);
        return new FuncFlexBoxViewHolder(view);
    }

    @Override
    public void onHandleLayoutParams(View view, int spanCount, int position) {
        FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) view.getLayoutParams();
        if ((position) % spanCount == 0) {
            lp.setWrapBefore(true);
        } else {
            lp.setWrapBefore(false);
        }
        view.setLayoutParams(lp);
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public void onBindViewHolder(FuncFlexBoxViewHolder holder, int position) {

    }

    public class FuncFlexBoxViewHolder extends FlexBoxViewHolder {

        public FuncFlexBoxViewHolder(View view) {
            super(view);
        }
    }
}