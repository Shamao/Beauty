package buykee.com.lab;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import buykee.com.common.base.BaseActivity;

/**
 * @author ssss
 */
@Route(path = "/lab/coordinator")
public class CoordinatorActivity extends BaseActivity {

    @BindView(R2.id.btn)
    Button mBtn;

    @Override
    public int getLayoutId() {
        return R.layout.lab_ac_coordinator;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initListener() {
        super.initListener();
        mBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    v.setX(event.getRawX() - v.getWidth() / 2);
                    v.setY(event.getRawY() - v.getHeight() / 2);
                }
                return false;
            }
        });
    }
}
