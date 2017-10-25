package beauty.louise.com.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lsd on 2017/10/23.
 */

public class MFuncBean {
    @SerializedName(value = "icon", alternate = {"icon_url"})
    private String mIcon;
    @SerializedName(value = "title", alternate = {"text"})
    private String mTitle;

    public MFuncBean() {
    }

    public MFuncBean(String icon, String title) {
        mIcon = icon;
        mTitle = title;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
