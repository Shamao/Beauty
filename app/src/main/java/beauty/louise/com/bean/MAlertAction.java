package beauty.louise.com.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Steam on 16/12/13.
 */

public class MAlertAction {


    /**
     * name : 使用手机登录
     * redirect_schema : cosmeapp://auth/login/
     */

    @SerializedName("name")
    private String mName;
    @SerializedName("redirect_schema")
    private String mRedirectSchema;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getRedirectSchema() {
        return mRedirectSchema;
    }

    public void setRedirectSchema(String redirectSchema) {
        mRedirectSchema = redirectSchema;
    }
}
