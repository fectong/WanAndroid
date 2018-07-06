package com.fec.ex.wanandroid.main.domain.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fec.ex.wanandroid.hierarchy.HierarchyFragment;
import com.fec.ex.wanandroid.main.MainFragment;
import com.fec.ex.wanandroid.project.ProjectFragment;
import com.fec.ex.wanandroid.settings.SettingsFragment;

/**
 * Created by Fe2Cu on 07.05.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_PAGES = 4;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return MainFragment.getInstance();
            case 1:
                return HierarchyFragment.getInstance();
            case 2:
                return ProjectFragment.getInstance();
            case 3:
                return SettingsFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
