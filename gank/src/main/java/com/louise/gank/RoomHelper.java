package com.louise.gank;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

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
        db = Room.databaseBuilder(mContext, AppDataBase.class, "gank").addCallback(new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        }).build();
    }

    public void insert(MGoods goods) {
        db.goodsDao().insertGoods(goods);
    }

    public List<MGoods> getGoods() {
        return db.goodsDao().getAll();
    }
}
