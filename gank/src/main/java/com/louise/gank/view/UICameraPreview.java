package com.louise.gank.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

/**
 * @author lsd
 * @date 2019/5/16.
 */
public class UICameraPreview extends ViewGroup implements SurfaceHolder.Callback {

    SurfaceView surfaceView;
    SurfaceHolder holder;

    public UICameraPreview(Context context) {
        super(context);
        surfaceView = new SurfaceView(context);
        addView(surfaceView);

        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        holder = surfaceView.getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public UICameraPreview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UICameraPreview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
