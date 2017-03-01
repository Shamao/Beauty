package princessmakeup.buykee.com.beauty.bean.index;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lsd on 17/1/9.
 */

public class AdBean {
    /**
     * img_url : http://static.cosmeapp.com/html/top/201701/06/20/40/586f902cad016679.jpg?imageMogr2/thumbnail/640x/gravity/North/crop/640x977
     * type : image
     * redirect_schema : cosmeapp://web/view/?url=https%3A%2F%2Fh5.cosmeapp.com%2Fauth%2Fsso-login%2F%3Fredirect%3Dhttp%253A%252F%252Fwww.cosmeapp.com%252Furl%252Fzst_kj20170109&encryption=1&stats=1&stats_type=coopenad&stats_data=http%3A%2F%2Fstatic.cosmeapp.com%2Fhtml%2Ftop%2F201701%2F06%2F20%2F40%2F586f902cad016679.jpg&
     * has_ad : 1
     * data : null
     * event_id : 92
     * ad_time : 4
     */

    @SerializedName("img_url")
    private String mImgUrl;
    @SerializedName("type")
    private String mType;
    @SerializedName("redirect_schema")
    private String mRedirectSchema;
    @SerializedName("has_ad")
    private String mHasAd;
    @SerializedName("data")
    private String mData;
    @SerializedName("event_id")
    private String mEventId;
    @SerializedName("ad_time")
    private String mAdTime;

    public String getImgUrl() {
        return mImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        mImgUrl = imgUrl;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getRedirectSchema() {
        return mRedirectSchema;
    }

    public void setRedirectSchema(String redirectSchema) {
        mRedirectSchema = redirectSchema;
    }

    public String getHasAd() {
        return mHasAd;
    }

    public void setHasAd(String hasAd) {
        mHasAd = hasAd;
    }

    public String getData() {
        return mData;
    }

    public void setData(String data) {
        mData = data;
    }

    public String getEventId() {
        return mEventId;
    }

    public void setEventId(String eventId) {
        mEventId = eventId;
    }

    public String getAdTime() {
        return mAdTime;
    }

    public void setAdTime(String adTime) {
        mAdTime = adTime;
    }
}
