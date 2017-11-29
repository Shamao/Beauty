package beauty.louise.com.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lsd on 2017/10/25.
 */

public class MTagBean {
    @SerializedName("title")
    private String mTitle;
    @SerializedName(value = "schema", alternate = {"redirect_schema"})
    private String mSchema;
    public MTagBean(String title) {
        mTitle = title;
    }

    public MTagBean withSchema(String schema) {
        mSchema = schema;
        return this;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getSchema() {
        return mSchema;
    }
}
