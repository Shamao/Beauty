package princessmakeup.buykee.com.common.bean;

/**
 * @author lsd
 * @date 2017/11/13.
 */

public class MAdBean {
    private String mAdTitle;
    private String mAdCover;

    public MAdBean() {
    }

    public MAdBean(String adTitle, String adCover) {
        mAdTitle = adTitle;
        mAdCover = adCover;
    }

    public String getAdTitle() {
        return mAdTitle;
    }

    public void setAdTitle(String adTitle) {
        mAdTitle = adTitle;
    }

    public String getAdCover() {
        return mAdCover;
    }

    public void setAdCover(String adCover) {
        mAdCover = adCover;
    }
}
