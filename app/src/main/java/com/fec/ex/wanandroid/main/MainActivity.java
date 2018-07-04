package com.fec.ex.wanandroid.main;

import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.fec.ex.wanandroid.R;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    private BottomAppBar mBottomAppBar;
    private FloatingActionButton mBottomFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomAppBar = findViewById(R.id.bottomAppBar);
        mBottomFAB = findViewById(R.id.bottomFAB);
        mBottomAppBar.replaceMenu(R.menu.main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment = MainFragment.getInstance();
        ft.add(fragment, "MainFragment");
        ft.replace(R.id.content, fragment);
        ft.commit();
    }

}
