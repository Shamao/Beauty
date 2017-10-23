package beauty.louise.com.bean.helper;

import java.util.List;

import beauty.louise.com.bean.MCoverBean;

/**
 * Created by lsd on 2017/10/24.
 */

public class MCoverList {

    private List<MCoverBean> mList;

    private MCoverList(List<MCoverBean> list) {
        mList = list;
    }

    public static MCoverList newInstance(List<MCoverBean> list) {
        return new MCoverList(list);
    }

    public List<MCoverBean> getList() {
        return mList;
    }

    public void setList(List<MCoverBean> list) {
        mList = list;
    }
}
