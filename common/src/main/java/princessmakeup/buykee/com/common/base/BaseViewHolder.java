package princessmakeup.buykee.com.common.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import princessmakeup.buykee.com.common.bean.MolLayoutBean;

/**
 * Created by lsd on 17/4/12.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public void initData() {
    }

    public void initView() {
    }

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        initData();
        initView();
    }

    public int dp2px(float dp) {
        return (int) (itemView.getContext().getResources().getDisplayMetrics().density * dp + 0.5);
    }

    protected int getScreenHeight() {
        return itemView.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    protected int getScreenWidth() {
        return itemView.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    public Context getContext() {
        return itemView.getContext();
    }

    public void fillLayout(MolLayoutBean layoutBean) {
        if (layoutBean == null) {
            return;
        }
        ViewGroup.LayoutParams lp = itemView.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }


        int width = layoutBean.getWidth();
        if (width != 0) {
            lp.width = width;
        }

        int height = layoutBean.getHeight();
        if (height != 0) {
            lp.height = height;
        }

        itemView.setLayoutParams(lp);

        int bgResId = layoutBean.getBgResId();
        itemView.setBackgroundResource(bgResId);
    }


}
