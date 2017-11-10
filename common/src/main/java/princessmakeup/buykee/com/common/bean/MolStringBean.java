package princessmakeup.buykee.com.common.bean;

/**
 *
 * @author ssss
 * @date 2017/11/3
 */

public class MolStringBean {

    private String mContent;
    private String mSchema;

    public MolStringBean(String content, String schema) {
        mContent = content;
        mSchema = schema;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getSchema() {
        return mSchema;
    }

    public void setSchema(String schema) {
        mSchema = schema;
    }
}
