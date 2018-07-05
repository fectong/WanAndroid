package com.fec.ex.wanandroid.hierarchy;

import com.fec.ex.wanandroid.base.BaseBean;
import com.fec.ex.wanandroid.helper.RetrofitManager;
import com.fec.ex.wanandroid.hierarchy.domain.HierarchyArticleList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class HierarchyPresenter implements HierarchyContract.Presenter {

    private HierarchyContract.View mView;
    private RetrofitManager mClient;
    private static final String TAG = "ProjectPresenter";

    public HierarchyPresenter(HierarchyContract.View view) {
        mView = view;
        mClient = RetrofitManager.instance();
    }

    @Override
    public void getHierarchyArticleList(int id, int cid) {
        mClient.getWanService()
                .getHierarchyArticleList(id ,cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<HierarchyArticleList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<HierarchyArticleList> hierarchyArticleListBaseBean) {
                        if (hierarchyArticleListBaseBean.getData().getDatas().size() != 0){
                            mView.showHierarchyArticleList(hierarchyArticleListBaseBean.getData().getDatas());
                        } else {
                            mView.showError();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
