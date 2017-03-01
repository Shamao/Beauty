package princessmakeup.buykee.com.beauty.ui.main;

import java.util.Map;

import princessmakeup.buykee.com.beauty.base.BasePresenter;
import princessmakeup.buykee.com.beauty.base.IBaseView;

/**
 * Created by lsd on 17/1/12.
 */

public class MainPresent extends BasePresenter<IBaseView> {
    MainModel mMainModel;

    public MainPresent(IBaseView view) {
        super(view);
        mMainModel = new MainModel(view.getContext(), this);
    }

    @Override
    public void loadData(int category, Map<String, String> params) {
        mMainModel.loadData(category, params);
    }


}
