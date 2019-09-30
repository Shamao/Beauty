package com.louise.gank.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.louise.gank.bean.MGoods;

@Database(entities = {MGoods.class}, version = 1,  exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract GoodsDao goodsDao();
}
