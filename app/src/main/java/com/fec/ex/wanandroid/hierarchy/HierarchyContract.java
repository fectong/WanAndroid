package com.fec.ex.wanandroid.hierarchy;

import android.view.View;

import com.fec.ex.wanandroid.base.BasePresenter;
import com.fec.ex.wanandroid.base.BaseView;
import com.fec.ex.wanandroid.hierarchy.domain.HierarchyArticleList;

import java.util.List;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public interface HierarchyContract {

    public interface View extends BaseView<Presenter> {

        void init(android.view.View view);

        void showHierarchyArticleList(List<HierarchyArticleList.DatasBean> hierarchyArticleList);

        void showError();
    }

    public interface Presenter extends BasePresenter {
        void getHierarchyArticleList(int id, int cid);
    }
}
