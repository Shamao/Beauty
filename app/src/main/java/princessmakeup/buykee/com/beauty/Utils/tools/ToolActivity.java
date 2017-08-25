package princessmakeup.buykee.com.beauty.Utils.tools;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import princessmakeup.buykee.com.beauty.R;

public class ToolActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<ToolType> mData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool);

        initBaseView();

        initView();
    }

    private void initBaseView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initView() {
        mData = new ArrayList<>();
        mData.add(ToolType.HelloWorld);
        mData.add(ToolType.Widget);
        ToolAdapter mAdapter = new ToolAdapter(mData);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.addItemDecoration(new ToolItemDecoration());
        mRecyclerView.setAdapter(mAdapter);
    }


    private class ToolAdapter extends RecyclerView.Adapter<ToolAdapter.CommonViewHolder> {
        private List<ToolType> mData;

        public ToolAdapter(List<ToolType> data) {
            mData = data;
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @Override
        public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tool_message, parent, false);
            return new CommonViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CommonViewHolder holder, int position) {
            final ToolType item = mData.get(position);
            holder.fillData(item.getValue());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (item) {
                        case HelloWorld:
                            Intent intent = new Intent(ToolActivity.this, HelloWorldActivity.class);
                            startActivity(intent);
                            break;
                        case Widget:

                            break;
                        default:
                            break;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }

        public class CommonViewHolder extends RecyclerView.ViewHolder {

            private TextView mMessageTv;

            public CommonViewHolder(View itemView) {
                super(itemView);
                mMessageTv = (TextView) itemView.findViewById(R.id.message_tv);
            }

            public void fillData(String message) {
                mMessageTv.setText(message);
            }
        }
    }

}
