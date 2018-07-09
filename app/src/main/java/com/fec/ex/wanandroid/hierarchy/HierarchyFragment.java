package com.fec.ex.wanandroid.hierarchy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.helper.RvItemClickListener;
import com.fec.ex.wanandroid.helper.Utils;
import com.fec.ex.wanandroid.hierarchy.domain.HierarchyArticleList;
import com.fec.ex.wanandroid.hierarchy.domain.adapter.HierarchyAdapter;
import com.fec.ex.wanandroid.hierarchy.domain.adapter.HierarchyArticleListAdapter;
import com.fec.ex.wanandroid.main.ArticleActivity;

import java.util.List;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class HierarchyFragment extends Fragment implements HierarchyContract.View {

    private final String TAG = this.getClass().getName();
    private HierarchyContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private HierarchyAdapter mAdapter;
    private List<HierarchyArticleList.DatasBean> mHierarchyArticleList;

    public static HierarchyFragment getInstance(){
        return new HierarchyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hierarchy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    @Override
    public void init(View view) {
        mRecyclerView = view.findViewById(R.id.rvHierarchy);
        mPresenter = new HierarchyPresenter(this);
        initData();
    }

    private void initData() {
        mPresenter.getHierarchyArticleList(0, 10);
    }

    @Override
    public void showHierarchyArticleList(List<HierarchyArticleList.DatasBean> hierarchyArticleList) {
        mHierarchyArticleList = hierarchyArticleList;
        mAdapter = new HierarchyAdapter(R.layout.item_hierarchy_list, mHierarchyArticleList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((adapter, view, position)
                -> Utils.toArticleView(getContext(), mHierarchyArticleList.get(position).getLink(), mHierarchyArticleList.get(position).getTitle()));
    }

    @Override
    public void showError() {

    }
}
