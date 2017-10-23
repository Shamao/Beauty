package beauty.louise.com.bean.helper;

import java.util.List;

import beauty.louise.com.bean.bean.MFuncBean;

/**
 * Created by lsd on 2017/10/24.
 */

public class MFuncList {
    List<MFuncBean> mList;

    private MFuncList(List<MFuncBean> list) {
        mList = list;
    }

    public static MFuncList newInstance(List<MFuncBean> list) {
        return new MFuncList(list);
    }

    public List<MFuncBean> getList() {
        return mList;
    }

    public void setList(List<MFuncBean> list) {
        mList = list;
    }
}
