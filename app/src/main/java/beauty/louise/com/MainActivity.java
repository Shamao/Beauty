package beauty.louise.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.utils.ActivityUtils;

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
                ActivityUtils.startActivity(MainActivity.this, Intent.ACTION_VIEW, null, null, "beauty://h.design.com/lab/main",
                                            null);
            }
        });
    }
}
