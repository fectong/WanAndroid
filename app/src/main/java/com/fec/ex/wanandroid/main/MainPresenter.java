package com.fec.ex.wanandroid.main;

import android.util.Log;

import com.fec.ex.wanandroid.base.BaseBean;
import com.fec.ex.wanandroid.helper.RetrofitManager;
import com.fec.ex.wanandroid.main.domain.model.Banner;
import com.fec.ex.wanandroid.main.domain.model.MainArticleList;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";
    private MainContract.View mView;
    private RetrofitManager mClient;
    private int mPage;

    public MainPresenter(MainContract.View view) {
        mView = view;
        mClient = RetrofitManager.instance();
        mPage = 0;
    }

    @Override
    public void getBannerData() {
        mClient.getWanService()
                .getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<List<Banner>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(BaseBean<List<Banner>> listBaseBean) {
                        mView.initBanner(listBaseBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void loadMoreArticleList() {
        mPage++;
        mClient.getWanService()
                .getMainArticleList(mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<MainArticleList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: Load Page: " + mPage);
                    }

                    @Override
                    public void onNext(BaseBean<MainArticleList> mainArticleListBaseBean) {
                        mView.refreshData(mainArticleListBaseBean.getData().getDatas());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMainArticleList() {
        mPage = 0;
        mClient.getWanService()
                .getMainArticleList(mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<MainArticleList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: Load Page: " + mPage);
                    }

                    @Override
                    public void onNext(BaseBean<MainArticleList> mainArticleListBaseBean) {
                        mView.showMainArticleList(mainArticleListBaseBean.getData().getDatas());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
