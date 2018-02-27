package com.louise.base.bean.gank;

import com.google.gson.annotations.SerializedName;

/**
 * @author lsd
 * @date 2018/2/7.
 */

public class MGankWelfareBean {

    /**
     * _id : 5a6e5f88421aa9115696004f
     * desc : 1-29
     * source : chrome
     * type : 福利
     * url : http://7xi8d6.com1.z0.glb.clouddn.com/20180129074038_O3ydq4_Screenshot.jpeg
     * used : true
     * who : daimajia
     */

    @SerializedName("_id")
    private String mId;
    @SerializedName("desc")
    private String mDesc;
    @SerializedName("source")
    private String mSource;
    @SerializedName("type")
    private String mType;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("used")
    private boolean mUsed;
    @SerializedName("who")
    private String mWho;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }


    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public boolean isUsed() {
        return mUsed;
    }

    public void setUsed(boolean used) {
        mUsed = used;
    }

    public String getWho() {
        return mWho;
    }

    public void setWho(String who) {
        mWho = who;
    }
}
