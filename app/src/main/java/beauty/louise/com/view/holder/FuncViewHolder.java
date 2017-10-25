package beauty.louise.com.view.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.flexbox.FlexboxLayout;

import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.base.BaseViewHolder;
import beauty.louise.com.bean.MFuncBean;
import beauty.louise.com.view.flexbox.FlexBoxAdapter;
import beauty.louise.com.view.flexbox.FlexBoxViewHolder;
import beauty.louise.com.view.flexbox.UIFlexBoxView;
import butterknife.BindView;

/**
 * Created by lsd on 2017/10/23.
 */

public class FuncViewHolder extends BaseViewHolder {
    @BindView(R.id.flex_box_view)
    UIFlexBoxView mFlexBoxView;

    public static int getLayoutId() {
        return R.layout.item_func_area;
    }

    public FuncViewHolder(View itemView) {
        super(itemView);
    }

    public void fillData(List<MFuncBean> list) {
        FuncAdapter adapter = new FuncAdapter(list, 4);
        mFlexBoxView.setAdapter(adapter);
    }

    public static class FuncAdapter extends FlexBoxAdapter<FuncAdapter.FuncFlexBoxViewHolder> {
        List<MFuncBean> mData;
        private int mSpanCount;


        public FuncAdapter(List<MFuncBean> data, int spanCount) {
            mData = data;
            mSpanCount = spanCount;
        }

        @Override
        public FuncFlexBoxViewHolder onCreateViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_func, parent, false);
            return new FuncFlexBoxViewHolder(view);
        }

        @Override
        public void onHandleLayoutParams(View view, int position) {
            FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) view.getLayoutParams();
            if ((position) % mSpanCount == 0) {
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

}
