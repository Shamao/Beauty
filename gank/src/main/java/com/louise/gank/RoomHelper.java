package com.louise.gank;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.louise.gank.bean.MGoods;
import com.louise.gank.db.AppDataBase;
import com.louise.gank.db.GoodsDao;

import java.util.List;

public class RoomHelper {
    public static RoomHelper helper;
    private AppDataBase db;
    private static Context mContext;

    public static RoomHelper getInstance() {
        if (helper == null) {
            helper = new RoomHelper();
        }

        return helper;
    }

    public static void init(Context context) {
        mContext = context;
    }

    public RoomHelper() {
        db = Room.databaseBuilder(mContext, AppDataBase.class, "gank").build();
    }

    public void insert(MGoods goods) {
        db.goodsDao().insertGoods(goods);
    }

    public List<MGoods> getGoods() {
        return db.goodsDao().getAll();
    }
}
