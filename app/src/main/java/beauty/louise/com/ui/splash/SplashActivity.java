package beauty.louise.com.ui.splash;

import android.os.Bundle;
import android.widget.ImageView;

import com.louise.base.base.BaseActivity;
import com.louise.base.bean.gank.MGankWelfareBean;
import com.louise.base.utils.ArrayUtils;
import com.louise.base.view.glide.GlideApp;
import com.louise.gank.GankApi;

import java.util.List;
import java.util.Random;

import beauty.louise.com.R;


/**
 * 启动页 功能需要简单 最多加载图片和gif
 *
 * @author ssss
 */
public class SplashActivity extends BaseActivity {
    private ImageView mCoverIv;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.ac_splash);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mCoverIv = findViewById(R.id.cover_iv);
        mCoverIv.postDelayed(new Runnable() {
            @Override
            public void run() {
                startAnimator();
            }
        }, 500);
    }

    private void startAnimator() {
        GankApi.getInstance().getGankWelfare(20, 1,
                new GankApi.Callback<List<MGankWelfareBean>>() {
                    @Override
                    public void onCallback(List<MGankWelfareBean> data) {
                        if (ArrayUtils.isNotEmpty(data)) {
                            int random = new Random().nextInt(data.size());
                            MGankWelfareBean item = data.get(random);
                            GlideApp.with(SplashActivity.this)
                                    .asBitmap()
                                    .load(item.getUrl())
                                    .placeholder(R.drawable.ic_placeholder)
                                    .dontAnimate()
                                    .into(mCoverIv);
                        }
                    }
                });
    }


}
