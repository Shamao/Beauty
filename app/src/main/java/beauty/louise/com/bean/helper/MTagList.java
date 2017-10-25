package beauty.louise.com.bean.helper;

import java.util.List;

import beauty.louise.com.bean.MTagBean;

/**
 * Created by lsd on 2017/10/25.
 */

public class MTagList {
    private List<MTagBean> mList;


    public static MTagList newInstance(List<MTagBean> list) {
        return new MTagList(list);
    }

    private MTagList(List<MTagBean> list) {
        mList = list;
    }

    public List<MTagBean> getList() {
        return mList;
    }

    public void setList(List<MTagBean> list) {
        mList = list;
    }
}
