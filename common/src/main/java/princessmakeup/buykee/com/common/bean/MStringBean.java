package princessmakeup.buykee.com.common.bean;

/**
 *
 * @author ssss
 * @date 2017/11/3
 */

public class MStringBean {
    public enum Type {
        LINE, BLOCK
    }

    private Type mType;
    private String mContent;
    private String mSchema;

    public MStringBean(Type type, String content, String schema) {
        mType = type;
        mContent = content;
        mSchema = schema;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
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
