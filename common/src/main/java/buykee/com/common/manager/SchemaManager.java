package buykee.com.common.manager;

import android.net.Uri;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author lsd
 * @date 2017/11/28.
 */

public class SchemaManager {
    public static final String S_HOST = "lsd.design.com";

    private SchemaManager() {
    }

    public static class Holder {
        public static SchemaManager mInstance = new SchemaManager();
    }

    public static SchemaManager getInstance() {
        return Holder.mInstance;
    }

    public void autoRedirect(String schema) {
        if (schema.contains(S_HOST)) {
            ARouter.getInstance().build(Uri.parse(schema)).navigation();
        } else {
            ARouter.getInstance().build(schema).navigation();
        }

    }
}
