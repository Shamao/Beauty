package beauty.louise.com.view.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.bean.MTagBean;
import beauty.louise.com.view.flexbox.FlexBoxAdapter;
import beauty.louise.com.view.flexbox.FlexBoxViewHolder;
import butterknife.BindView;

/**
 * Created by lsd on 2017/10/25.
 */

public class TagAdapter extends FlexBoxAdapter<TagAdapter.TagFlexBoxViewHolder> {

    private List<MTagBean> mList;

    public TagAdapter(List<MTagBean> list) {
        mList = list;
    }

    @Override
    public TagAdapter.TagFlexBoxViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tag, parent, false);
        return new TagFlexBoxViewHolder(view);
    }

    @Override
    public void onHandleLayoutParams(View view, int spanCount, int position) {

    }

    @Override
    public void onBindViewHolder(TagAdapter.TagFlexBoxViewHolder holder, int position) {
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
            Drawable drawable =  mTitleTv.getBackground().mutate();
            drawable.setAlpha(121);
            mTitleTv.setBackground(drawable);
            mTitleTv.setText(item.getTitle());
        }
    }
}
