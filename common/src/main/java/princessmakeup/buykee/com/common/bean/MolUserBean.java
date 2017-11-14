package princessmakeup.buykee.com.common.bean;

/**
 * @author lsd
 * @date 2017/11/14.
 */

public class MolUserBean {
    private String mAvatarUrl;
    private String mUsername;
    private String mDesc;


    public MolUserBean() {
    }

    public MolUserBean(String avatarUrl, String username, String desc) {
        mAvatarUrl = avatarUrl;
        mUsername = username;
        mDesc = desc;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }
}
