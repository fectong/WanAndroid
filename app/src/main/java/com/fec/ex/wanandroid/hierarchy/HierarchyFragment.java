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
import com.fec.ex.wanandroid.hierarchy.domain.HierarchyArticleList;
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
    private HierarchyArticleListAdapter mAdapter;
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
        mRecyclerView = getView().findViewById(R.id.rvHierarchy);
        mPresenter = new HierarchyPresenter(this);
        mPresenter.getHierarchyArticleList(0, 10);
    }

    @Override
    public void showHierarchyArticleList(List<HierarchyArticleList.DatasBean> hierarchyArticleList) {
        mHierarchyArticleList = hierarchyArticleList;
        Log.d(TAG, "showHierarchyArticleList: "+mHierarchyArticleList.size());
        mAdapter = new HierarchyArticleListAdapter(mHierarchyArticleList);
        Log.d(TAG, "showHierarchyArticleList: "+mAdapter.getItemCount());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.addOnItemTouchListener(new RvItemClickListener(getContext(), mRecyclerView, new RvItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), ArticleActivity.class);
                intent.putExtra("URL", mHierarchyArticleList.get(position).getLink());
                intent.putExtra("TITLE", mHierarchyArticleList.get(position).getTitle());
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    @Override
    public void showError() {
        Snackbar.make(getView(), "Get article list failed.", Snackbar.LENGTH_SHORT).setAction("I SEE", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }).show();
    }
}
