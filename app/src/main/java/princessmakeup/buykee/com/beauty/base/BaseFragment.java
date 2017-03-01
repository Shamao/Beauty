package princessmakeup.buykee.com.beauty.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Type;
import java.util.Map;

import butterknife.ButterKnife;
import princessmakeup.buykee.com.common.utils.Logger;
import princessmakeup.buykee.com.common.utils.constant.ConstTag;

/**
 * Created by Steam on 16/12/21.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {
    protected String tag;
    protected P mPresenter;

    public abstract int getLayoutId();

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected abstract void initData();


    protected void initListener() {
    }

    protected void loadData() {
    }


    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        tag = getClass().getSimpleName();
        Logger.d(ConstTag.LifeCycle, tag + "-onAttach");
        initData();
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {// TODO: 16/12/22
            throw new RuntimeException(context.toString()
                                               + " must implement OnFragmentInteractionListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.d(ConstTag.LifeCycle, tag + "-onCreateView");
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Logger.d(ConstTag.LifeCycle, tag + "-onViewCreated");
        initBaseData(view, savedInstanceState);
        initView(view, savedInstanceState);
    }

    private void initBaseData(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.d(ConstTag.LifeCycle, tag + "-onActivityCreated");
        loadData();
        initListener();
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.d(ConstTag.LifeCycle, tag + "-onStart");
        if (mPresenter != null) {
            mPresenter.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d(ConstTag.LifeCycle, tag + "-onResume");
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.d(ConstTag.LifeCycle, tag + "-onPause");
        if (mPresenter != null) {
            mPresenter.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.d(ConstTag.LifeCycle, tag + "-onStop");
        if (mPresenter != null) {
            mPresenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(ConstTag.LifeCycle, tag + "-onDestroy");
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter.detachView();
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        Logger.d(ConstTag.LifeCycle, tag + "-onDetach");
        listener = null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Logger.d(ConstTag.LifeCycle, tag + "-setUserVisibleHint");
        }
    }

    /**
     * 已处理debug和release 减少代码量
     *
     * @param Object
     */
    protected void logger(Object... Object) {
        Logger.d(tag, Object);
    }


    protected OnFragmentInteractionListener listener;

    public interface OnFragmentInteractionListener {
        /**
         * activity 和  fragment 通讯
         *
         * @param content
         * @param type
         */
        void onFragmentInteraction(String content, Type type);
    }

}
