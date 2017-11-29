package buykee.com.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import buykee.com.common.utils.Logger;
import buykee.com.common.utils.constant.ConstTag;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Steam on 16/12/21.
 */

public abstract class BaseFragment extends Fragment {
    protected String mTag;
    private Unbinder mUnBinder;

    public abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected void initListener() {
    }

    protected void loadData() {
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mTag = getClass().getSimpleName() + "@" + hashCode();
        Logger.d(ConstTag.LifeCycle, mTag + "-onAttach");
        initInnerData();
    }

    private void initInnerData() {
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.d(ConstTag.LifeCycle, mTag + "-onCreateView");
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Logger.d(ConstTag.LifeCycle, mTag + "-onViewCreated");
        initInnerView(view, savedInstanceState);

    }

    private void initInnerView(View view, @Nullable Bundle savedInstanceState) {
        mUnBinder = ButterKnife.bind(this, view);
        initView(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.d(ConstTag.LifeCycle, mTag + "-onActivityCreated");
        loadData();
        initListener();
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.d(ConstTag.LifeCycle, mTag + "-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d(ConstTag.LifeCycle, mTag + "-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.d(ConstTag.LifeCycle, mTag + "-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.d(ConstTag.LifeCycle, mTag + "-onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(ConstTag.LifeCycle, mTag + "-onDestroy");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
        Logger.d(ConstTag.LifeCycle, mTag + "-onDestroyView");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.d(ConstTag.LifeCycle, mTag + "-onDetach");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Logger.d(ConstTag.LifeCycle, mTag + "-setUserVisibleHint");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
