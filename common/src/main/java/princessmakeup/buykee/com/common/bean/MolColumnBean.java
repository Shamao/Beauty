package princessmakeup.buykee.com.common.bean;

/**
 * @author lsd
 */

public class MolColumnBean {
    /**
     * 基础数据
     */
    private String mTitle;
    private String mTitleSchema;
    private String mDesc;
    private String mDescSchema;
    /**
     * 布局信息
     */
    private MolLayoutBean mLayoutBean;

    public MolColumnBean() {
    }

    public  MolColumnBean withTitle(String title, String schema) {
        this.mTitle = title;
        mTitleSchema = schema;
        return this;

    }

    public  MolColumnBean withDesc(String desc, String schema) {
        this.mDesc = desc;
        mDescSchema = schema;
        return this;

    }


    public MolColumnBean withLayout(MolLayoutBean layoutBean) {
        this.mLayoutBean = layoutBean;
        return this;
    }

    public MolLayoutBean getLayoutBean() {
        return mLayoutBean;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }



    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public String getDescSchema() {
        return mDescSchema;
    }

    public void setDescSchema(String descSchema) {
        mDescSchema = descSchema;
    }

    public MolColumnBean(String titleSchema) {
        mTitleSchema = titleSchema;
    }
}
