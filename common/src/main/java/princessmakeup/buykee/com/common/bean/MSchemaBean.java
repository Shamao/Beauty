package princessmakeup.buykee.com.common.bean;

/**
 * Created by lsd on 2017/10/26.
 */

public class MSchemaBean {
    private String mContent;
    private String mSchema;

    public MSchemaBean(String content, String schema) {
        mContent = content;
        mSchema = schema;
    }

    public String getSchema() {
        return mSchema;
    }

    public void setSchema(String schema) {
        mSchema = schema;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }
}
