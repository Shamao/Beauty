package beauty.louise.com.view.holder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import beauty.louise.com.R;
import beauty.louise.com.base.BaseViewHolder;
import beauty.louise.com.bean.MImageBean;
import beauty.louise.com.view.provider.ImageProvider;
import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by lsd on 17/9/22.
 */

public class BannerViewHolder extends BaseViewHolder {
    public static int getLayoutId() {
        return R.layout.item_banner;
    }

    @BindView(R.id.banner_recycler)
    RecyclerView mBannerRV;
    MultiTypeAdapter mBannerAdapter;
    List<MImageBean> mData;
    int mResultWidth;
    int mResultHeight;

    public BannerViewHolder(View itemView) {
        super(itemView);
        mResultWidth = getScreenWidth();
        mResultHeight = (int) (mResultWidth * 0.5f);
        mData = new ArrayList<>();
        mBannerAdapter = new MultiTypeAdapter(mData);
        mBannerAdapter.register(MImageBean.class, new ImageProvider());
        mBannerRV.setHasFixedSize(true);
        mBannerRV.setLayoutManager(
                new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mBannerRV.setAdapter(mBannerAdapter);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(mBannerRV);
    }

    public void fillData(List<MImageBean> data) {
        ViewGroup.LayoutParams lp = mBannerRV.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mResultHeight);
        } else {
            lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            lp.height = mResultHeight;
        }
        mBannerRV.setLayoutParams(lp);
        mData.clear();
        mData.addAll(data);
        mBannerAdapter.notifyDataSetChanged();
    }

}
