package beauty.louise.com.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.youku.cloud.module.PlayerErrorInfo;
import com.youku.cloud.player.PlayerListener;
import com.youku.cloud.player.VideoDefinition;
import com.youku.cloud.player.YoukuPlayerView;
import com.youku.cloud.player.YoukuUIListener;
import com.youku.cloud.utils.PlayerUtils;

import beauty.louise.com.R;
import butterknife.BindView;
import buykee.com.common.base.BaseActivity;
import buykee.com.common.utils.ActivityUtils;
import buykee.com.common.utils.Logger;

/**
 * 播放器播放界面
 */
public class PlayerActivity extends BaseActivity implements YoukuUIListener {

    public static void startActivity(Activity activity, String vid) {
        Bundle bundle = new Bundle();
        bundle.putString("vid", vid);
        ActivityUtils.startActivity(activity, PlayerActivity.class, bundle);
    }

    @BindView(R.id.player_container)
    View mPlayContainer;
    private String vid;
    private String password;
    private boolean local = false;
    private YoukuPlayerView youkuPlayerView;

    @Override
    public int getLayoutId() {
        return R.layout.a_player;
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        vid = intent.getStringExtra("vid");
        vid = "XNDY5Njc0MTA4";
        local = intent.getBooleanExtra("local", false);
        password = intent.getStringExtra("password");
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        youkuPlayerView = (YoukuPlayerView) findViewById(R.id.baseview);
        //        txt1 = (TextView) findViewById(R.id.txt1);
        // 初始化播放器
        youkuPlayerView.attachActivity(this);
        // 不使用默认的横竖屏设置
        youkuPlayerView.setUseOrientation(false);
        youkuPlayerView.setPreferVideoDefinition(VideoDefinition.VIDEO_HD);
        youkuPlayerView.setShowBackBtn(true);
        youkuPlayerView.setPlayerListener(new MyPlayerListener());
        youkuPlayerView.setUIListener(this);


        autoPlayVideo();
        initEvent();
    }

    // 进入activity后自动播放，如不需要
    private void autoPlayVideo() {
        if (local) {
            youkuPlayerView.playLocalVideo(vid);
        } else {
            if (TextUtils.isEmpty(password)) {
                youkuPlayerView.playYoukuVideo(vid);
            } else {
                youkuPlayerView.playYoukuPrivateVideo(vid, password);
            }
        }

    }

    @Override
    protected void onPause() {
        Log.e("liyh", "player onPause");
        super.onPause();
        // 必须重写的onPause()

    }

    @Override
    protected void onResume() {
        youkuPlayerView.onResume();
        Log.e("liyh", "player onResume");
        super.onResume();
        // 必须重写的onResume()
    }

    @Override
    protected void onDestroy() {
        youkuPlayerView.onDestroy();
        Log.e("liyh", "player onDestroy");
        super.onDestroy();
        // 必须重写的onDestroy()

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e("liyh", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.e("liyh", "onSaveInstanceState2");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        //后退键的处理，当全屏时，后退为变为小屏
        if (youkuPlayerView.isFullScreen()) {
            youkuPlayerView.goSmallScreen();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onBackBtnClick() {
        onBackPressed();
    }

    @Override
    public void onFullBtnClick() {
        if (youkuPlayerView.isFullScreen()) {
            goTabletSmall();
        } else {
            goTabletFull();
        }
    }


    // 添加播放器的监听器
    private class MyPlayerListener extends PlayerListener {
        @Override
        public void onComplete() {
            // TODO Auto-generated method stub
            super.onComplete();
        }

        @Override
        public void onError(int code, PlayerErrorInfo info) {
            // TODO Auto-generated method stub
            Logger.d(mTag, info.getDesc());
        }

        @Override
        public void OnCurrentPositionChanged(int msec) {
            // TODO Auto-generated method stub
            super.OnCurrentPositionChanged(msec);
        }

        @Override
        public void onVideoNeedPassword(int code) {
            // TODO Auto-generated method stub
            super.onVideoNeedPassword(code);
        }

        @Override
        public void onVideoSizeChanged(int width, int height) {
            // TODO Auto-generated method stub
            super.onVideoSizeChanged(width, height);
        }
    }

    private void initEvent() {

        // 使页面初始为横屏
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // 即使响应为竖屏，也强制设置为横屏，这样可以始终保持横屏
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    // 平板小屏状态
    private void goTabletSmall() {
        youkuPlayerView.goSmallScreen();
        youkuPlayerView.showSystemUI();
        ViewGroup.LayoutParams params = mPlayContainer.getLayoutParams();
        params.width = PlayerUtils.dip2px(400);
        params.height = PlayerUtils.dip2px(400f * 9f / 16f);
        mPlayContainer.setLayoutParams(params);
    }

    // 平板全屏状态
    private void goTabletFull() {
        youkuPlayerView.goFullScreen();
        youkuPlayerView.hideSystemUI();
        ViewGroup.LayoutParams params = mPlayContainer.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        mPlayContainer.setLayoutParams(params);
    }
}
