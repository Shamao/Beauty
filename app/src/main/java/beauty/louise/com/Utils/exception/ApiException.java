package beauty.louise.com.Utils.exception;

/**
 * Created by Steam on 16/11/25.
 */

public class ApiException extends RuntimeException {

    private int mErrorCode;
    private String mErrorMsg;

    public ApiException(int errorCode, String errorMessage){
        super(errorMessage);
        mErrorMsg = errorMessage;
        mErrorCode = errorCode;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    public String getErrorMsg() {
        return mErrorMsg;
    }
}
