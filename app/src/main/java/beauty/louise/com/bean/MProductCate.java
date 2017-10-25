package beauty.louise.com.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Steam on 16/11/25.
 */

public class MProductCate implements Serializable {


    /**
     * cat_id : 2
     * cat_name : 全部
     * title : 护肤
     * redirect_schema : mCosmeapp://product/list/?cat_id=2&type_key=cat_id&title=%E6%8A%A4%E8%82%A4&
     */

    @SerializedName("cat_id")
    private String mCatId;
    @SerializedName("cat_name")
    private String mCatName;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("redirect_schema")
    private String mRedirectSchema;

    public String getCatId() {
        return mCatId;
    }

    public void setCatId(String catId) {
        mCatId = catId;
    }

    public String getCatName() {
        return mCatName;
    }

    public void setCatName(String catName) {
        mCatName = catName;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getRedirectSchema() {
        return mRedirectSchema;
    }

    public void setRedirectSchema(String redirectSchema) {
        mRedirectSchema = redirectSchema;
    }
}
