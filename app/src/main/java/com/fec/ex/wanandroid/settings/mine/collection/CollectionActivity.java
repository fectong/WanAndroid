package com.fec.ex.wanandroid.settings.mine.collection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fec.ex.wanandroid.R;

/**
 * Created by Fe2Cu on 07.10.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class CollectionActivity extends AppCompatActivity implements CollectionContract.View {

    private final String TAG = this.getClass().getName();
    private CollectionContract.Presenter mPresenter;
    private CollapsingToolbarLayout mCollapsingToolbar;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        mPresenter = new CollectionPresenter(this);
    }

    private void initToolbar() {
        mCollapsingToolbar = findViewById(R.id.collapsing_toolbar);
        mToolbar = findViewById(R.id.toolbar);
        mCollapsingToolbar.setTitleEnabled(false);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(R.string.collection_list);
    }
}
