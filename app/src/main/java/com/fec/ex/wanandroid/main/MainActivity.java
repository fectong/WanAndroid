package com.fec.ex.wanandroid.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.main.domain.BottomNavigationViewBehavior;
import com.fec.ex.wanandroid.main.domain.adapter.MyPagerAdapter;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private final String TAG = this.getClass().getName();
    private BottomNavigationView mBottomNavigationView;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBottomNavigationView();
        initViewPager();
    }

    private void initBottomNavigationView() {
        mBottomNavigationView = findViewById(R.id.bottomNav);
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) mBottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());
    }

    private void initViewPager() {
        mViewPager = findViewById(R.id.viewPager);
        mViewPager.addOnPageChangeListener(this);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mViewPager.setCurrentItem(item.getOrder());
            return true;
        }
    };

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mBottomNavigationView.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
