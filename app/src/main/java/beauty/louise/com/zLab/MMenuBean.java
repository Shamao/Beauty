package beauty.louise.com.zLab;

/**
 * Created by lsd on 17/9/20.
 */

public class MMenuBean {
    private String mTitle;
    private String mSchema;

    public MMenuBean(String title, String schema) {
        mTitle = title;
        mSchema = schema;
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
}
