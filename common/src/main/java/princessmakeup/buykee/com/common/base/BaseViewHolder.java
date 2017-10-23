package princessmakeup.buykee.com.common.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

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

}
