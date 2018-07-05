package com.fec.ex.wanandroid.project;

import com.fec.ex.wanandroid.base.BasePresenter;
import com.fec.ex.wanandroid.base.BaseView;
import com.fec.ex.wanandroid.project.domain.model.ProjectList;

import java.util.List;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public interface ProjectContract {

    public interface View extends BaseView<Presenter> {
        void showProjectList(List<ProjectList.DatasBean> projectList);
    }

    public interface Presenter extends BasePresenter {
        void getProjectList(int id, int cid);
    }

}
