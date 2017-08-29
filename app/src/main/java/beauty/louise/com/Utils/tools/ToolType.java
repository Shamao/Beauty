package beauty.louise.com.Utils.tools;

import static android.R.style.Widget;

/**
 * Created by lsd on 17/5/16.
 */

public enum  ToolType {

    HelloWorld("hello world"),Widget("基本控件");

    private String value;

    ToolType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
