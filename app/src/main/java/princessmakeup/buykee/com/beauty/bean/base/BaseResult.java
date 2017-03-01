package princessmakeup.buykee.com.beauty.bean.base;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Steam on 16/11/24.
 */

public class BaseResult<T> implements Serializable {

    @SerializedName("status")
    private int mStatus;
    @SerializedName("msg")
    private String mMsg;
    @SerializedName("data")
    private T mData;

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }
}
