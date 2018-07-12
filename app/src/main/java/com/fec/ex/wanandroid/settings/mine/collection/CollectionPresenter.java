package com.fec.ex.wanandroid.settings.mine.collection;

import com.fec.ex.wanandroid.base.BaseBean;
import com.fec.ex.wanandroid.helper.RetrofitManager;
import com.fec.ex.wanandroid.helper.RxHelper;
import com.fec.ex.wanandroid.settings.mine.collection.domain.model.CollectionList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Fe2Cu on 07.07.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class CollectionPresenter implements CollectionContract.Presenter {
    private CollectionContract.View mView;
    private RetrofitManager mClient;
    private int mPage;

    public CollectionPresenter(CollectionContract.View view) {
        mView = view;
        mClient = RetrofitManager.instance();
        mPage = 0;
    }

    @Override
    public void getCollectionList(boolean loadMore) {
        if (!loadMore) {
            mPage = 0;
        } else {
            mPage++;
        }
        mClient.getWanService()
                .getCollectionList(mPage)
                .compose(RxHelper.io2main())
                .subscribe(new Observer<BaseBean<CollectionList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<CollectionList> collectionList) {
                        if (collectionList.getErrorCode() == collectionList.SUCCESS) {
                            if (collectionList.getData() != null) {
                                if (!loadMore) {
                                    mView.showCollectionList(collectionList.getData().getDatas());
                                } else {
                                    mView.refreshData(collectionList.getData().getDatas());
                                }
                            } else {
                                mView.showError("No More");
                            }
                        } else {
                            mView.showError("Failed");
                        }
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
