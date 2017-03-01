package princessmakeup.buykee.com.beauty.bean.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Steam on 16/12/13.
 */

public class MAlert {


    /**
     * title : 该手机号还未注册，请检查输入的手机号是否正确，您也可以使用手机动态密码，免注册直接登录
     * negative : {"name":"取消"}
     * positive : {"name":"使用手机登录","redirect_schema":"cosmeapp://auth/login/"}
     */

    @SerializedName("title")
    private String mTitle;
    @SerializedName("negative")
    private MAlertAction mNegative;
    @SerializedName("positive")
    private MAlertAction mPositive;
    @SerializedName("neutral")
    private MAlertAction mNeutral;


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public MAlertAction getNegative() {
        return mNegative;
    }

    public void setNegative(MAlertAction negative) {
        mNegative = negative;
    }

    public MAlertAction getPositive() {
        return mPositive;
    }

    public void setPositive(MAlertAction positive) {
        mPositive = positive;
    }

    public MAlertAction getNeutral() {
        return mNeutral;
    }

    public void setNeutral(MAlertAction neutral) {
        mNeutral = neutral;
    }
}
