package com.louise.gank;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.base.service.MExecutorService;
import com.louise.gank.bean.MGoods;

import cc.hiy.baseui.titlebar.UITitleBar;
import cc.hiy.baseui.titlebar.UITitleDelegate;

@Route(path = "/gank/goods/new")
public class GankGoodsNewActivity extends BaseActivity {

    private UITitleBar mTitleBar;
    private EditText mGoodsNameEt;


    @Override
    public int getLayoutId() {
        return R.layout.gank_ac_new_goods;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mTitleBar = findViewById(R.id.title_bar);
        UITitleDelegate delegate = new UITitleDelegate();

        delegate.bindTitle(this, mTitleBar, "添加商品");
        delegate.bindLeftBack(this, mTitleBar, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        delegate.bindRightImage(this, mTitleBar, R.drawable.ic_blue, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });


        mGoodsNameEt = findViewById(R.id.goods_et);
    }


    private void save() {
        String goodsName = mGoodsNameEt.getText().toString().trim();

        final MGoods goods = new MGoods();
        goods.name = goodsName;


        MExecutorService.newThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                RoomHelper.getInstance().insert(goods);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                });
            }
        });
    }

}
