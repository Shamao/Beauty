package princessmakeup.buykee.com.beauty.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import princessmakeup.buykee.com.beauty.R;
import princessmakeup.buykee.com.beauty.base.BaseFragmentActivity;
import princessmakeup.buykee.com.common.utils.Logger;
import princessmakeup.buykee.com.common.utils.constant.ConstCategory;
import princessmakeup.buykee.com.common.utils.constant.ConstTag;

import static princessmakeup.buykee.com.beauty.R.id.drawer;
import static princessmakeup.buykee.com.beauty.R.id.toolbar;


public class MainActivity extends BaseFragmentActivity {
    @BindView(toolbar)
    Toolbar mToolbar;
    @BindView(drawer)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.recycler_nav)
    RecyclerView mNavRecycler;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        mPresenter = new MainPresent(this);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            ActionBarDrawerToggle toggle =
                    new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.hello_world,
                                              R.string.hello_world);
            mDrawerLayout.addDrawerListener(toggle);
            toggle.syncState();
        }


    }

    @Override
    public void loadData() {
        super.loadData();
        loadUserCenter();

    }


    /**
     * 加载用户信息
     */
    private void loadUserCenter() {
        Map<String, String> params = new HashMap<>();
        params.put("user_id", "24801006");
        mPresenter.loadData(ConstCategory.MAIN_CENTER, params);
    }


    private void loadSettingInfo() {

    }

    @Override
    public void initListener() {
        super.initListener();
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d(ConstTag.Click, "navigation");
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_user:
                        Logger.d(ConstTag.Click, "user");
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onSuccess(int category, Object object) {
         if (category==ConstCategory.MAIN_CENTER){
             Logger.d("todo","MAIN_CENTER");
         }
    }

    @Override
    public void onFailed(Object object) {


    }


    @Override
    public Fragment newInstance() {
        return HomeFragment.newInstance(null);
    }

    @Override
    public int getContainerId() {
        return R.id.container;
    }

    @Override
    public void onFragmentInteraction(String content, Type type) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
