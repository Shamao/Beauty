package beauty.louise.com.Utils.exception;


import beauty.louise.com.bean.MAlert;

/**
 * Created by Steam on 16/12/13.
 */

public class HasAlertException extends Exception {

    private int mStatus;
    private String mMsg;
    private MAlert mAlert;


    public HasAlertException(int status, String msg, MAlert alert) {
        super(msg);
        mStatus = status;
        mMsg = msg;
        mAlert = alert;
    }

    public int getStatus() {
        return mStatus;
    }

    public String getMsg() {
        return mMsg;
    }

    public MAlert getAlert() {
        return mAlert;
    }
}
