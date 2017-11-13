package princessmakeup.buykee.com.common.bean;

/**
 * @author lsd
 */

public class MolColumnBean {
    /**
     * 基础数据
     */
    private String mTitle;
    private String mSchema;
    private String mDesc;
    /**
     * 布局信息
     */
    private MolLayoutBean mLayoutBean;

    public MolColumnBean(String title, String desc, String schema) {
        mTitle = title;
        mSchema = schema;
        mDesc = desc;
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

    public String getSchema() {
        return mSchema;
    }

    public void setSchema(String schema) {
        mSchema = schema;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }
}
