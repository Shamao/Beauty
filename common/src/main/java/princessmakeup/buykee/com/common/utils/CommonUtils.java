package princessmakeup.buykee.com.common.utils;

import princessmakeup.buykee.com.common.utils.constant.ConstTag;

/**
 * Created by lsd on 17/1/17.
 */

public class CommonUtils {
    public static void printNanoTimeTime() {
        Logger.e(ConstTag.nanoTime, System.nanoTime());
    }
}
