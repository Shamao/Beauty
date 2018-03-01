package beauty.louise.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.sdk.android.AppLinkService;
import com.alibaba.sdk.android.BaseAlibabaSDK;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ssss
 */
@Route(path = "/main/main")
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.title_tv)
    TextView mTitleTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        ButterKnife.bind(this);

        mTitleTv.setText(hashCode() + "");
        mTitleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppLinkService link = BaseAlibabaSDK.getService(AppLinkService.class);
                link.jumpDetail(MainActivity.this, "552461663816", null);
            }
        });
    }
}
