package com.fec.ex.wanandroid.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.helper.GlideImageLoader;
import com.fec.ex.wanandroid.main.domain.Banner;
import com.fec.ex.wanandroid.main.domain.MainArticleList;
import com.fec.ex.wanandroid.main.domain.MainListAdapter;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class MainFragment extends Fragment implements MainContract.View, OnBannerListener {

    private final String TAG = this.getClass().getName();
    private MainContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private MainListAdapter adapter;
    private com.youth.banner.Banner mBanner;
    private List<String> mBannerUrlList;
    private List<Banner> bannerList;
    private List<MainArticleList.DatasBean> mArticleList;

    public static MainFragment getInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBanner = view.findViewById(R.id.mainBanner);
        mPresenter = new MainPresenter(this);
        mPresenter.getBanner();
        mPresenter.getMainArticleList(0);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
    }


    @Override
    public void OnBannerClick(int position) {
        Intent intent = new Intent(getContext(), ArticleActivity.class);
        intent.putExtra("URL", bannerList.get(position).getUrl());
        startActivity(intent);
    }

    @Override
    public void initBanner(List<Banner> listBanner) {
        bannerList = listBanner;
        mBannerUrlList = new ArrayList<>();
        for (Banner banner : listBanner) {
            mBannerUrlList.add(banner.getImagePath());
        }
        mBanner.setImages(mBannerUrlList)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start();
    }

    @Override
    public void showMainArticleList(final List<MainArticleList.DatasBean> articleList) {
        mArticleList = articleList;
        adapter = new MainListAdapter(mArticleList);
        adapter.setOnItemClickListener(new MainListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), ArticleActivity.class);
                intent.putExtra("URL", articleList.get(position).getLink());
                startActivity(intent);
            }
        });
        mRecyclerView = getView().findViewById(R.id.rvMainArticle);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
    }

}
