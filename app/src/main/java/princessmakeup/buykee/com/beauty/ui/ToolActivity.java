package princessmakeup.buykee.com.beauty.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import princessmakeup.buykee.com.beauty.R;

public class ToolActivity extends AppCompatActivity {

    @BindView(R.id.tv_app)
    TextView mTvApp;
    @BindView(R.id.tv_html)
    TextView mTvHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool);
        ButterKnife.bind(this);

    }
}
