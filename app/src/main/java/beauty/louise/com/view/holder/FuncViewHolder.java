package beauty.louise.com.view.holder;

import android.view.View;

import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.base.BaseViewHolder;
import beauty.louise.com.bean.MFuncBean;
import beauty.louise.com.view.adapter.FuncAdapter;
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
        FuncAdapter adapter = new FuncAdapter(list);
        mFlexBoxView.setSpanCount(4);
        mFlexBoxView.setAdapter(adapter);
    }

}
