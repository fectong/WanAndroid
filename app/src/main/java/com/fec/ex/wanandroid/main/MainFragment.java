package com.fec.ex.wanandroid.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.helper.GlideImageLoader;
import com.fec.ex.wanandroid.helper.Utils;
import com.fec.ex.wanandroid.main.domain.adapter.MainAdapter;
import com.fec.ex.wanandroid.main.domain.model.Banner;
import com.fec.ex.wanandroid.main.domain.model.MainArticleList;
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
    private MainAdapter mAdapter;
    private com.youth.banner.Banner mBanner;
    private List<String> mBannerUrlList;
    private List<Banner> bannerList;
    private List<MainArticleList.DatasBean> mArticleList;

    public static MainFragment getInstance() {
        return new MainFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    @Override
    public void init(View view) {
        mPresenter = new MainPresenter(this);
        mRecyclerView = view.findViewById(R.id.rvMainArticle);
        mBannerUrlList = new ArrayList<>();
        mArticleList = new ArrayList<>();
        mAdapter = new MainAdapter(R.layout.item_article_list, mArticleList);

        LinearLayout mHeaderGroup = ((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.banner_main, null));
        mBanner = mHeaderGroup.findViewById(R.id.mainBanner);
        mHeaderGroup.removeView(mBanner);

        initRV();
        initData();
    }

    private void initRV() {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapter.addHeaderView(mBanner);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener((adapter, view, position)
                -> Utils.toArticleView(getContext(), mArticleList.get(position).getLink(), mArticleList.get(position).getTitle()));
        mAdapter.setOnLoadMoreListener(() -> {
            mPresenter.getArticleList(true);
        }, mRecyclerView);
    }

    private void initData() {
        mPresenter.getBannerData();
        mPresenter.getArticleList(false);
    }

    @Override
    public void OnBannerClick(int position) {
        Utils.toArticleView(getContext(), bannerList.get(position).getUrl(), bannerList.get(position).getTitle());
    }

    @Override
    public void initBanner(List<Banner> listBanner) {
        bannerList = listBanner;
        mBannerUrlList.clear();
        for (Banner banner : listBanner) {
            mBannerUrlList.add(banner.getImagePath());
        }
        mBanner.setImages(mBannerUrlList)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start();
    }

    @Override
    public void showMainArticleList(List<MainArticleList.DatasBean> articleList) {
        mArticleList.clear();
        mArticleList = articleList;
        mAdapter.replaceData(articleList);
    }

    @Override
    public void refreshData(final List<MainArticleList.DatasBean> articleList) {
        mArticleList.addAll(articleList);
        mAdapter.addData(articleList);
        mAdapter.loadMoreComplete();
    }
}
