package com.louise.gank.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomDatabase;

import com.louise.gank.bean.MGoods;

import java.util.List;

@Dao
public interface GoodsDao {
    @Query("SELECT * FROM goods")
    List<MGoods> getAll();

    @Insert()
    public void insertGoods(MGoods... goods);
}
