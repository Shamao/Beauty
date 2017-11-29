package buykee.com.common.bean;

/**
 * @author lsd
 * @date 2017/11/13.
 */

public class MolSeparatorBean {
    private MolLayoutBean mLayoutBean;

    public MolSeparatorBean withLayout(MolLayoutBean layoutBean) {
        mLayoutBean = layoutBean;
        return this;
    }

    public MolLayoutBean getLayoutBean() {
        return mLayoutBean;
    }
}
