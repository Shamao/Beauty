package beauty.louise.com.view.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.base.BaseViewHolder;
import beauty.louise.com.bean.MTagBean;
import beauty.louise.com.view.flexbox.FlexBoxAdapter;
import beauty.louise.com.view.flexbox.FlexBoxViewHolder;
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
    TagFlexBoxAdapter mAdapter;

    public TagViewHolder(View itemView) {
        super(itemView);
    }

    public void fillData(List<MTagBean> list) {
        mAdapter = new TagFlexBoxAdapter(list);
        mTagView.setAdapter(mAdapter);
        mTagView.setOnFlexBoxItemClickListener(new OnFlexBoxItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ToastUtils.showShort(view.getContext(), "大兄弟 别走" + position);
            }
        });
    }

    public class TagFlexBoxAdapter extends FlexBoxAdapter<TagFlexBoxAdapter.TagFlexBoxViewHolder> {

        private List<MTagBean> mList;

        public TagFlexBoxAdapter(List<MTagBean> list) {
            mList = list;
        }

        @Override
        public TagFlexBoxAdapter.TagFlexBoxViewHolder onCreateViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tag, parent, false);
            return new TagFlexBoxViewHolder(view);
        }

        @Override
        public void onHandleLayoutParams(View view, int position) {

        }

        @Override
        public void onBindViewHolder(TagFlexBoxAdapter.TagFlexBoxViewHolder holder, int position) {
            holder.fillData(mList.get(position));
        }

        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

        public class TagFlexBoxViewHolder extends FlexBoxViewHolder {

            @BindView(R.id.title_tv)
            TextView mTitleTv;

            public TagFlexBoxViewHolder(View view) {
                super(view);
            }

            public void fillData(MTagBean item) {
                mTitleTv.setText(item.getTitle());
            }
        }
    }
}
