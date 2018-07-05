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
import com.fec.ex.wanandroid.main.ArticleActivity;
import com.fec.ex.wanandroid.project.domain.adapter.ProjectListAdapter;
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
    private ProjectListAdapter mAdapter;
    private List<ProjectList.DatasBean> mProjectList;

    public static ProjectFragment getInstance(){
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
        mPresenter = new ProjectPresenter(this);
        mPresenter.getProjectList(1, 294);
    }

    @Override
    public void showProjectList(List<ProjectList.DatasBean> projectList) {
        mProjectList = projectList;
        mAdapter = new ProjectListAdapter(mProjectList);
        mRecyclerView = getView().findViewById(R.id.rvProject);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.addOnItemTouchListener(new RvItemClickListener(getContext(), mRecyclerView, new RvItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), ArticleActivity.class);
                intent.putExtra("URL", mProjectList.get(position).getLink());
                intent.putExtra("TITLE", mProjectList.get(position).getTitle());
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}
