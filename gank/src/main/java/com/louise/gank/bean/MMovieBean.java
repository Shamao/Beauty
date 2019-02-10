package com.louise.gank.bean;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * @author lsd
 * @date 2018/3/5.
 */


public class MMovieBean extends BaseObservable{

    public final ObservableField<String> firstName =
            new ObservableField<>();

    public final ObservableField<String> lastName =
            new ObservableField<>();

    public final ObservableInt age = new ObservableInt();

}
