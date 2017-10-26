package beauty.louise.com.view.holder;

import android.view.View;

import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.base.BaseViewHolder;
import beauty.louise.com.bean.MTagBean;
import beauty.louise.com.view.adapter.TagAdapter;
import beauty.louise.com.view.flexbox.OnFlexBoxItemClickListener;
import beauty.louise.com.view.flexbox.UIFlexBoxView;
import butterknife.BindView;
import princessmakeup.buykee.com.common.utils.ToastUtils;

/**
 * Created by lsd on 2017/10/25.
 */

public class TagViewHolder extends BaseViewHolder {
    public static int getLayoutId() {
        return R.layout.item_tag_area;
    }

    @BindView(R.id.tag_view)
    UIFlexBoxView mTagView;
    TagAdapter mAdapter;

    public TagViewHolder(View itemView) {
        super(itemView);
    }

    public void fillData(List<MTagBean> list) {
        mAdapter = new TagAdapter(list);
        mTagView.setAdapter(mAdapter);
        mTagView.setOnFlexBoxItemClickListener(new OnFlexBoxItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ToastUtils.showShort(view.getContext(), "大兄弟 别走" + position);
            }
        });
    }
}
