package com.louise.gank.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.louise.gank.bean.MContact;
import com.louise.gank.bean.MGoods;

import java.util.List;

@Dao
public interface ContactDao {

    @Query("SELECT * FROM contact")
    List<MContact> getAll();

    @Insert()
    public void insertContact(MContact... contacts);
}
