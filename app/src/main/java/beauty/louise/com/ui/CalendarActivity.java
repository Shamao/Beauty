package beauty.louise.com.ui;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.Calendar;

import beauty.louise.com.R;
import beauty.louise.com.view.calendar.schedule.ScheduleLayout;
import butterknife.BindView;
import buykee.com.common.base.BaseActivity;

/**
 * @author lsd
 * @date 2017/11/28.
 */

@Route(path = "/main/calendar")
public class CalendarActivity extends BaseActivity{
    @BindView(R.id.slSchedule)
    ScheduleLayout mScheduleLayout;
    private int mCurrentSelectYear, mCurrentSelectMonth, mCurrentSelectDay;
    private long mTime;
    @Override
    public int getLayoutId() {
        return R.layout.ac_calendar;
    }

    @Override
    public void initData() {
        Calendar calendar = Calendar.getInstance();
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }
}
