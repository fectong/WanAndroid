package com.fec.ex.wanandroid.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.helper.RvItemClickListener;
import com.fec.ex.wanandroid.helper.Utils;
import com.fec.ex.wanandroid.main.ArticleActivity;
import com.fec.ex.wanandroid.project.domain.adapter.ProjectAdapter;
import com.fec.ex.wanandroid.project.domain.model.ProjectList;

import java.util.List;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class ProjectFragment extends Fragment implements ProjectContract.View {

    private final String TAG = this.getClass().getName();
    private ProjectContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private ProjectAdapter mAdapter;
    private List<ProjectList.DatasBean> mProjectList;

    public static ProjectFragment getInstance() {
        return new ProjectFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_project, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    @Override
    public void init(View view) {
        mRecyclerView = view.findViewById(R.id.rvProject);
        mPresenter = new ProjectPresenter(this);
        initData();
    }

    private void initData() {
        mPresenter.getProjectList(1, 294);
    }

    @Override
    public void showProjectList(List<ProjectList.DatasBean> projectList) {
        mProjectList = projectList;
        mAdapter = new ProjectAdapter(R.layout.item_article_list, mProjectList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((adapter, view, position)
                -> Utils.toArticleView(getContext(), mProjectList.get(position).getLink(), mProjectList.get(position).getTitle()));
    }
}
