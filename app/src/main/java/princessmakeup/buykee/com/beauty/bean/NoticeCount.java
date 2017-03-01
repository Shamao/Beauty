package princessmakeup.buykee.com.beauty.bean;


import princessmakeup.buykee.com.beauty.bean.bean.MNoticeCount;

/**
 * Created by Steam on 16/11/29.
 */

public class NoticeCount {

    private static MNoticeCount mNoticeCount;

    public static void getNoticeCount(){

    }

    public static int getTimeAJust(){
        if(mNoticeCount == null){
            mNoticeCount = new MNoticeCount();
        }
        return mNoticeCount.getTimeAjust();
    }

    public static String getTimeStamp(){
        return ((System.currentTimeMillis() / 1000) + getTimeAJust()) + "";
    }
}
