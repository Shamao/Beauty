package princessmakeup.buykee.com.lab;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import princessmakeup.buykee.com.common.base.BaseActivity;
import princessmakeup.buykee.com.common.bean.MolColumnBean;
import princessmakeup.buykee.com.lab.view.adapter.ColumnAdapter;
import princessmakeup.buykee.com.lab.view.adapter.FixAdapter;
import princessmakeup.buykee.com.lab.view.adapter.FloatAdapter;
import princessmakeup.buykee.com.lab.view.adapter.GridAdapter;
import princessmakeup.buykee.com.lab.view.adapter.LinearAdapter;
import princessmakeup.buykee.com.lab.view.adapter.OnePlusAdapter;
import princessmakeup.buykee.com.lab.view.adapter.ScrollFixAdapter;
import princessmakeup.buykee.com.lab.view.adapter.SingleAdapter;
import princessmakeup.buykee.com.lab.view.adapter.StaggeredAdapter;
import princessmakeup.buykee.com.lab.view.adapter.StickyAdapter;

@Route(path = "/lab/vLayout")
public class LabVLayoutActivity extends BaseActivity {

    @BindView(R2.id.recycler)
    RecyclerView mRecyclerView;

    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_vlayout;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        // 将VirtualLayoutManager绑定到recyclerView
        mRecyclerView.setLayoutManager(layoutManager);

        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 1);

        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        mRecyclerView.setAdapter(delegateAdapter);

        final List<DelegateAdapter.Adapter> adapters = new LinkedList<>();

        List<MolColumnBean> columnList = new ArrayList<>();
        for (int i = 0 ;i < 5; i++) {
            columnList.add(new MolColumnBean().withTitle("Linear", null));
        }
        adapters.add(new LinearAdapter(columnList));
        adapters.add(new LinearAdapter(columnList));
        adapters.add(new StickyAdapter(columnList));
        adapters.add(new GridAdapter(columnList));
        adapters.add(new FixAdapter(columnList));
        adapters.add(new ScrollFixAdapter(columnList));
        adapters.add(new FloatAdapter(columnList));
        adapters.add(new ColumnAdapter(columnList));
        adapters.add(new SingleAdapter(columnList));
        adapters.add(new OnePlusAdapter(columnList));
        adapters.add(new StaggeredAdapter(columnList));
        adapters.add(new StaggeredAdapter(columnList));
        adapters.add(new StaggeredAdapter(columnList));
        delegateAdapter.addAdapters(adapters);
        delegateAdapter.notifyDataSetChanged();

//        final List<LayoutHelper> helpers = new LinkedList<>();
//
//
//        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
//
//        final GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
//        gridLayoutHelper.setItemCount(25);
//
//        final ScrollFixLayoutHelper scrollFixLayoutHelper =
//                new ScrollFixLayoutHelper(FixLayoutHelper.TOP_RIGHT, 100, 100);
//
//        helpers.add(DefaultLayoutHelper.newHelper(7));
//        helpers.add(scrollFixLayoutHelper);
//        helpers.add(DefaultLayoutHelper.newHelper(2));
//        helpers.add(gridLayoutHelper);
//
//        layoutManager.setLayoutHelpers(helpers);

        //        mRecyclerView.setAdapter(new VirtualLayoutAdapter(layoutManager) {
        //            @Override
        //            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //                return new MainViewHolder(new TextView(LabVLayoutActivity.this));
        //            }
        //
        //            @Override
        //            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //                VirtualLayoutManager.LayoutParams layoutParams = new VirtualLayoutManager.LayoutParams(
        //                        ViewGroup.LayoutParams.MATCH_PARENT, 100);
        //                holder.itemView.setLayoutParams(layoutParams);
        //
        //                ((TextView) holder.itemView).setText(String.valueOf(position));
        //
        ////                if (position == 7) {
        ////                    layoutParams.height = 60;
        ////                    layoutParams.width = 60;
        ////                } else if (position > 35) {
        ////                    layoutParams.height = 200 + (position - 30) * 100;
        ////                }
        ////
        ////                if (position > 35) {
        ////                    holder.itemView.setBackgroundColor(0x66cc0000 + (position - 30) * 128);
        ////                } else if (position % 2 == 0) {
        ////                    holder.itemView.setBackgroundColor(0xaa00ff00);
        ////                } else {
        ////                    holder.itemView.setBackgroundColor(0xccff00ff);
        ////                }
        //            }
        //
        //            @Override
        //            public int getItemCount() {
        //                List<LayoutHelper> helpers = getLayoutHelpers();
        //                if (helpers == null) {
        //                    return 0;
        //                }
        //                int count = 0;
        //                for (int i = 0, size = helpers.size(); i < size; i++) {
        //                    count += helpers.get(i).getItemCount();
        //                }
        //                return count;
        //            }
        //        });
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder(View itemView) {
            super(itemView);
        }
    }
}
