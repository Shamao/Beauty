package com.louise.gank.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseMVCActivity;
import com.louise.base.service.MExecutorService;
import com.louise.gank.R;
import com.louise.gank.RoomHelper;
import com.louise.gank.bean.MContact;
import com.louise.gank.bean.utils.BeanUtils;

@Route(path = "/gank/contact/create")
public class GankContactCreateActivity extends BaseMVCActivity {

    private EditText mPhoneEt, mNameEt;
    private TextView mConfirmTv;

    @Override
    public int getLayoutId() {
        return R.layout.gank_ac_contact_create;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mPhoneEt = findViewById(R.id.phone_et);
        mNameEt = findViewById(R.id.name_et);
        mConfirmTv = findViewById(R.id.confirm_tv);
    }

    @Override
    public void initListener() {
        mConfirmTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = mPhoneEt.getText().toString().trim();
                String name = mNameEt.getText().toString().trim();

                final MContact contact = BeanUtils.buildContact(name, phone);
                MExecutorService.newThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
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
        });
    }
}
