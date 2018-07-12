package com.fec.ex.wanandroid.settings.mine.collection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.helper.Utils;
import com.fec.ex.wanandroid.settings.mine.collection.domain.adapter.CollectionAdapter;
import com.fec.ex.wanandroid.settings.mine.collection.domain.model.CollectionList;

import java.util.ArrayList;
import java.util.List;

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
    private CollectionAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<CollectionList.DatasBean> mCollectionList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        init();
    }

    private void init() {
        mPresenter = new CollectionPresenter(this);
        mRecyclerView = findViewById(R.id.rvCollection);
        mCollectionList = new ArrayList<>();
        mAdapter = new CollectionAdapter(R.layout.item_collection_list, mCollectionList);

        initToolbar();
        initRV();
        initData();
    }

    private void initToolbar() {
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitleEnabled(false);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.collection_list);
    }

    private void initRV() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setOnItemClickListener((adapter, view, position)
                -> Utils.toArticleView(this, mCollectionList.get(position).getLink(), mCollectionList.get(position).getTitle())
        );
        mAdapter.setOnLoadMoreListener(()-> mPresenter.getCollectionList(true), mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mPresenter.getCollectionList(false);
    }

    @Override
    public void showCollectionList(List<CollectionList.DatasBean> collectionList) {
        mCollectionList.clear();
        mCollectionList = collectionList;
        mAdapter.replaceData(mCollectionList);
        mAdapter.disableLoadMoreIfNotFullPage();
    }

    @Override
    public void refreshData(List<CollectionList.DatasBean> collectionList) {
        mCollectionList.addAll(collectionList);
        mAdapter.addData(collectionList);
        mAdapter.loadMoreComplete();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
