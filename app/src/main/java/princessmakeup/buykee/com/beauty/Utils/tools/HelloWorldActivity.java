package princessmakeup.buykee.com.beauty.Utils.tools;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import princessmakeup.buykee.com.beauty.R;

public class HelloWorldActivity extends Activity {
    private TextView mHelloTv;

    private Button mSwitch;



    private StringBuilder mBuilder = new StringBuilder();
    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        mHelloTv = (TextView) findViewById(R.id.hello_world_tv);
        mSwitch = (Button) findViewById(R.id.switch_btn);
        mSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char b = (char) ('a'+i);
                mBuilder.append(b);
                i++;
                mHelloTv.setText(mBuilder.toString());
            }
        });
    }
}
