package com.louise.base.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author lsd
 * @date 2018/2/7.
 */

public class BaseResult<T> {
    @SerializedName(value = "code", alternate = {"status"})
    private String mStatus;
    @SerializedName(value = "error")
    private boolean mError;

    @SerializedName(value = "results", alternate = {"'data"})
    private T mT;

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public boolean isError() {
        return mError;
    }

    public void setError(boolean error) {
        mError = error;
    }

    public T getT() {
        return mT;
    }

    public void setT(T t) {
        mT = t;
    }
}
