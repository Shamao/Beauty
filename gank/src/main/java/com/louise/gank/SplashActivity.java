package com.louise.gank;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;
import com.louise.base.manager.RouterManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/gank/splash")
public class SplashActivity extends BaseActivity {

    @BindView(R2.id.gank_video_view)
    VideoView mVideoView;


    @Override
    public void initContentLayout() {
        setContentView(R.layout.gank_ac_splash);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        File videoFile = getFileStreamPath("gank_splash.mp4");
        if (!videoFile.exists()) {
            videoFile = copyVideoFile();
        }
        playVideo(videoFile);
    }

    private void playVideo(File videoFile) {
        mVideoView.setVideoPath(videoFile.getPath());
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(false);
                mediaPlayer.start();
            }
        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(SplashActivity.this, "结束播放", Toast.LENGTH_SHORT).show();
                RouterManager.getInstance().navigation(SplashActivity.this, "/gank/main");
            }
        });
    }

    private File copyVideoFile() {
        File videoFile;
        try {
            FileOutputStream fos = openFileOutput("gank_splash.mp4", MODE_APPEND);
            InputStream in = getResources().openRawResource(R.raw.gank_splash);
            byte[] buff = new byte[1024];
            int len;
            while ((len = in.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        videoFile = getFileStreamPath("gank_splash.mp4");
        if (!videoFile.exists()) {
            throw new RuntimeException(
                    "video file has problem, are you sure you have welcome_video.mp4 in res/raw folder?");
        }
        return videoFile;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
    }


    @OnClick(R2.id.gank_next_tv)
    void onNextClick(View view) {
        startActivity(new Intent(this, GankMainActivity.class), ActivityOptions
                .makeSceneTransitionAnimation(this).toBundle());
    }
}
