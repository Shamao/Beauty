package com.louise.gank;

import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;

import com.louise.base.base.BaseActivity;
import com.louise.base.utils.ALogger;

public class GankCameraActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.gank_ac_camera;
    }


    Camera camera;

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    private boolean safeCameraOpen(int id) {
        boolean qOpened = false;

        try {
            releaseCameraAndPreview();
            camera = Camera.open(id);
            qOpened = (camera != null);
        } catch (Exception e) {
            ALogger.e("failed to open Camera");
            e.printStackTrace();
        }

        return qOpened;
    }

    private void releaseCameraAndPreview() {
        if (camera != null) {
            camera.release();
            camera = null;
        }
    }


}
