package com.fec.ex.wanandroid.main;

import com.fec.ex.wanandroid.base.BaseBean;
import com.fec.ex.wanandroid.base.BasePresenter;
import com.fec.ex.wanandroid.base.BaseView;
import com.fec.ex.wanandroid.main.domain.MainArticleList;
import com.youth.banner.Banner;

import java.util.List;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public interface MainContract {

    public interface View extends BaseView<Presenter> {

        void initBanner(List<com.fec.ex.wanandroid.main.domain.Banner> listBanner);

        void showMainArticleList(List<MainArticleList.DatasBean> articleList);

    }

    public interface Presenter extends BasePresenter {

        void detachView();

        void getBanner();

        void getMainArticleList(int page);

    }
}
