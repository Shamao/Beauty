package com.louise.gank;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.base.service.MExecutorService;
import com.louise.gank.bean.MContact;
import com.louise.gank.bean.MGoods;

import java.util.ArrayList;

import cc.hiy.baseui.titlebar.UITitleBar;
import cc.hiy.baseui.titlebar.UITitleDelegate;

@Route(path = "/gank/goods/new")
public class GankGoodsNewActivity extends BaseActivity {
    @Autowired(name = "true", required = true, desc = "sss")
    public int type;

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
//                RoomHelper.getInstance().insert(goods);

                MContact contact = new MContact();
                contact.name = "爸爸";
                contact.phones = new ArrayList<>();
                contact.phones.add("13777836524");
                contact.phones.add("18952520273");

                RoomHelper.getInstance().insert(goods);
                RoomHelper.getInstance().insert(contact);

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
