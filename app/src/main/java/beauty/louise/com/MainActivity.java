package beauty.louise.com;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.louise.base.base.BaseActivity;

import beauty.louise.com.view.NoScrollViewPager;

/**
 * @author ssss
 */
@Route(path = "/main/main")
public class MainActivity extends BaseActivity {

    private NoScrollViewPager mNoScrollViewPager;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.ac_main);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mNoScrollViewPager = findViewById(R.id.pager);
        mNoScrollViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, final int position) {
                TextView tv = new TextView(container.getContext());
                ViewGroup.LayoutParams  lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.MATCH_PARENT);
                tv.setLayoutParams(lp);
                tv.setText(String.valueOf(position));
                container.addView(tv);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mNoScrollViewPager.setCurrentItem((position + 1) % getCount(),false);
                    }
                });
                return tv;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//                super.destroyItem(container, position, object);
                container.removeView((View) object);
            }
        });
    }

}
