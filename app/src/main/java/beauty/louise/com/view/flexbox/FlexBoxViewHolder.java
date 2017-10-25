package beauty.louise.com.view.flexbox;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by lsd on 2017/10/24.
 */

public class FlexBoxViewHolder {
    protected View itemView;

    public FlexBoxViewHolder(View view) {
        this.itemView = view;
        ButterKnife.bind(this, view);
    }
}
