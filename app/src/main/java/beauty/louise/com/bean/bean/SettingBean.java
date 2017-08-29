package beauty.louise.com.bean.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lsd on 17/1/23.
 */

public class SettingBean {


    /**
     * atteninfo : {"status":"0","title":"你有18积分可兑换","desc":"签到+3","creditmarket":"cosmeapp://web/view/?url=http%3A%2F%2Ftest.h5.cosmeapp.com%2Fauth%2Fsso-login%2F%3Fredirect%3Dhttp%253A%252F%252Ftest.h5.cosmeapp.com%252Fcredit%252Findex%2523%2521%252F&encryption=1&"}
     * list : [[{"type":"noticecenter","title":"消息","icon":"http://static.cosmeapp.com/FhnuUHhOjUpZfi2HqIfJ_U7dSer6","count":"0","redirect_schema":"cosmeapp://user/noticecenter/?stats=1&stats_type=usercenter&stats_data=noticecenter&"},{"type":"myproductfav","title":"欲望清单","icon":"http://static.cosmeapp.com/FtJQrHi8l2zOrxQhkItUpVLQwU8a","count":"0","redirect_schema":"cosmeapp://product/list/?type_key=user_fav&needlogin=1&title=%E6%AC%B2%E6%9C%9B%E6%B8%85%E5%8D%95&"},{"type":"mybbsfav","title":"我的收藏","icon":"http://static.cosmeapp.com/FsDzdyjxhPFLGBVatGGuKYpYtGln","count":"0","redirect_schema":"cosmeapp://user/mybbsfav/?needlogin=1&stats=1&stats_type=usercenter&stats_data=mybbsfav&"}],[{"type":"myorder","title":"我的订单","icon":"http://static.cosmeapp.com/Fs39SxKT1bgT1TrVkxiURmn0I7_x","count":"0","redirect_schema":"http://test.h5.cosmeapp.com/order/list/"},{"type":"coupon","title":"兑换码/邀请码","icon":"http://static.cosmeapp.com/FvQAjqcwD_14akHvcCDGYf2Wkgj3","count":"0","redirect_schema":"cosmeapp://web/view/?encryption=1&needlogin=1&url=http%3A%2F%2Ftest.h5.cosmeapp.com%2Fauth%2Fsso-login%2F%3Fredirect%3Dhttp%253A%252F%252Ftest.h5.cosmeapp.com%252Fuser%252Finvite%253Fcode%253DQ9TY0E0K&stats=1&stats_type=usercenter&stats_data=coupon&"}],[{"type":"skintest","title":"肤质测试","icon":"http://static.cosmeapp.com/FlWgPY8ueIW2uvK4kwFfaYvEbgE-","count":"0","redirect_schema":"cosmeapp://web/view/?url=http%3A%2F%2Ftest.h5.cosmeapp.com%2Fauth%2Fsso-login%2F%3Fredirect%3Dhttp%253A%252F%252Fwww.cosmeapp.com%252Furl%252Fskintest&encryption=1&"},{"type":"beautyclock","title":"美容闹钟","icon":"http://static.cosmeapp.com/FsKfs6HyIf16zY6NbcMa9VOsIHgt","count":"0","redirect_schema":"cosmeapp://user/beautyclock/?stats=1&stats_type=usercenter&stats_data=beautyclock&"}],[{"type":"feedback","title":"意见反馈","icon":"http://static.cosmeapp.com/FjDBR3X8IAFurHCJdiLycLNKS38c","count":"0","redirect_schema":"cosmeapp://web/view/?encryption=1&url=http%3A%2F%2Ftest.h5.cosmeapp.com%2Fauth%2Fsso-login%2F%3Fredirect%3Dhttp%253A%252F%252Ftest.h5.cosmeapp.com%252Ffeedback%252Fentrance&needlogin=1&stats=1&stats_type=usercenter&stats_data=feedback&"},{"type":"letter","title":"致用户的一封信","icon":"http://static.cosmeapp.com/FhYw6cQWxeLNwyBawTjguqVW2hMt","count":"0","redirect_schema":"cosmeapp://web/view/?url=http%3A%2F%2Ftest.h5.cosmeapp.com%2Fauth%2Fsso-login%2F%3Fredirect%3Dhttp%253A%252F%252Fpublic.cosmeapp.com%252Fmapp%252Fsettings%252Fletter.html&encryption=1&stats=1&stats_type=usercenter&stats_data=letter&"}]]
     */

    @SerializedName("atteninfo")
    private IntegralItem mIntegralBean;
    @SerializedName("list")
    private List<List<SettingItem>> mList;


    public IntegralItem getIntegralBean() {
        return mIntegralBean;
    }

    public void setIntegralBean(IntegralItem integralBean) {
        mIntegralBean = integralBean;
    }

    public List<List<SettingItem>> getList() {
        return mList;
    }

    public void setList(List<List<SettingItem>> list) {
        mList = list;
    }

    public static class IntegralItem {
        /**
         * status : 0
         * title : 你有18积分可兑换
         * desc : 签到+3
         * creditmarket : cosmeapp://web/view/?url=http%3A%2F%2Ftest.h5.cosmeapp.com%2Fauth%2Fsso-login%2F%3Fredirect%3Dhttp%253A%252F%252Ftest.h5.cosmeapp.com%252Fcredit%252Findex%2523%2521%252F&encryption=1&
         */

        @SerializedName("status")
        private String mStatus;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("desc")
        private String mDesc;
        @SerializedName("creditmarket")
        private String mCreditmarket;

        public String getStatus() {
            return mStatus;
        }

        public void setStatus(String status) {
            mStatus = status;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        public String getDesc() {
            return mDesc;
        }

        public void setDesc(String desc) {
            mDesc = desc;
        }

        public String getCreditmarket() {
            return mCreditmarket;
        }

        public void setCreditmarket(String creditmarket) {
            mCreditmarket = creditmarket;
        }
    }

    public static class SettingItem {
        /**
         * type : noticecenter
         * title : 消息
         * icon : http://static.cosmeapp.com/FhnuUHhOjUpZfi2HqIfJ_U7dSer6
         * count : 0
         * redirect_schema : cosmeapp://user/noticecenter/?stats=1&stats_type=usercenter&stats_data=noticecenter&
         */

        @SerializedName("type")
        private String mType;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("icon")
        private String mIcon;
        @SerializedName("count")
        private String mCount;
        @SerializedName("redirect_schema")
        private String mRedirectSchema;

        public String getType() {
            return mType;
        }

        public void setType(String type) {
            mType = type;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        public String getIcon() {
            return mIcon;
        }

        public void setIcon(String icon) {
            mIcon = icon;
        }

        public String getCount() {
            return mCount;
        }

        public void setCount(String count) {
            mCount = count;
        }

        public String getRedirectSchema() {
            return mRedirectSchema;
        }

        public void setRedirectSchema(String redirectSchema) {
            mRedirectSchema = redirectSchema;
        }
    }
}
