package com.fec.ex.wanandroid.project;

import com.fec.ex.wanandroid.base.BaseBean;
import com.fec.ex.wanandroid.helper.RetrofitManager;
import com.fec.ex.wanandroid.helper.RxHelper;
import com.fec.ex.wanandroid.project.domain.model.ProjectList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class ProjectPresenter implements ProjectContract.Presenter {

    private ProjectContract.View mView;
    private RetrofitManager mClient;
    private static final String TAG = "ProjectPresenter";

    public ProjectPresenter(ProjectContract.View view) {
        mView = view;
        mClient = RetrofitManager.instance();
    }

    @Override
    public void getProjectList(int id, int cid) {
        mClient.getWanService()
                .getProjectList(id, cid)
                .compose(RxHelper.io2main())
                .subscribe(new Observer<BaseBean<ProjectList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<ProjectList> projectListBaseBean) {
                        mView.showProjectList(projectListBaseBean.getData().getDatas());
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
