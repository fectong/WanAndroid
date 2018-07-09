package com.fec.ex.wanandroid.settings.mine.collection;

/**
 * Created by Fe2Cu on 07.07.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class CollectionPresenter implements CollectionContract.Presenter {
    private CollectionContract.View mView;

    public CollectionPresenter(CollectionContract.View view) {
        mView = view;
    }
}
