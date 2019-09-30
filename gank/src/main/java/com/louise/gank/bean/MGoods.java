package com.louise.gank.bean;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * 商品
 */
@Entity(tableName = "goods")
public class MGoods {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String name;
}
