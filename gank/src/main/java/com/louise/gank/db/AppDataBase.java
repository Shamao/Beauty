package com.louise.gank.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.louise.gank.RoomTypeConvert;
import com.louise.gank.bean.MContact;
import com.louise.gank.bean.MGoods;

@TypeConverters({RoomTypeConvert.class})
@Database(entities = {MGoods.class, MContact.class}, version = 3, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract GoodsDao goodsDao();

    public abstract ContactDao contactDao();
}
