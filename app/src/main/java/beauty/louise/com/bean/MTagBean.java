package beauty.louise.com.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lsd on 2017/10/25.
 */

public class MTagBean {
    @SerializedName("title")
    private String mTitle;

    public MTagBean(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
