package beauty.louise.com.bean.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Steam on 16/11/29.
 */

public class MNoticeCount {

    /**
     * refresh_image_url :
     * usercenter_count : 2
     * time_ajust : 142
     */

    @SerializedName("refresh_image_url")
    private String mRefreshImageUrl;
    @SerializedName("usercenter_count")
    private int mUsercenterCount;
    @SerializedName("time_ajust")
    private int mTimeAjust;

    public String getRefreshImageUrl() {
        return mRefreshImageUrl;
    }

    public void setRefreshImageUrl(String refreshImageUrl) {
        mRefreshImageUrl = refreshImageUrl;
    }

    public int getUsercenterCount() {
        return mUsercenterCount;
    }

    public void setUsercenterCount(int usercenterCount) {
        mUsercenterCount = usercenterCount;
    }

    public int getTimeAjust() {
        return mTimeAjust;
    }

    public void setTimeAjust(int timeAjust) {
        mTimeAjust = timeAjust;
    }
}
