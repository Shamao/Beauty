package beauty.louise.com.bean.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Steam on 16/12/13.
 */

public class AlertData {

    @SerializedName("alert")
    private MAlert mAlert;

    public MAlert getAlert() {
        return mAlert;
    }

    public void setAlert(MAlert alert) {
        mAlert = alert;
    }
}
