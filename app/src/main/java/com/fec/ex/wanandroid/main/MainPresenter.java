package com.fec.ex.wanandroid.main;

import android.util.Log;

import com.fec.ex.wanandroid.base.BaseBean;
import com.fec.ex.wanandroid.helper.GlideImageLoader;
import com.fec.ex.wanandroid.helper.RetrofitManager;
import com.fec.ex.wanandroid.main.domain.Banner;
import com.fec.ex.wanandroid.main.domain.MainArticleList;

import java.util.ArrayList;
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

    private MainContract.View mView;
    private RetrofitManager client;
    private static final String TAG = "MainPresenter";

    public MainPresenter(MainContract.View view) {
        mView = view;
        mView.setPresenter(this);
        client = RetrofitManager.instance();
    }

    @Override
    public void start() {

    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public void getBanner() {
        client.getWanService()
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
    public void getMainArticleList(int page) {
        client.getWanService()
                .getMainArticleList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<MainArticleList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
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
