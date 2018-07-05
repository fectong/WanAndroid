package com.fec.ex.wanandroid.main;

import com.fec.ex.wanandroid.base.BasePresenter;
import com.fec.ex.wanandroid.base.BaseView;
import com.fec.ex.wanandroid.main.domain.model.MainArticleList;

import java.util.List;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public interface MainContract {

    public interface View extends BaseView<Presenter> {

        void initBanner(List<com.fec.ex.wanandroid.main.domain.model.Banner> listBanner);

        void showMainArticleList(List<MainArticleList.DatasBean> articleList);

    }

    public interface Presenter extends BasePresenter {

        void getBanner();

        void getMainArticleList(int page);

    }
}
