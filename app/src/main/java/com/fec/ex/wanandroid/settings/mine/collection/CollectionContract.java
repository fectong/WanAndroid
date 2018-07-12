package com.fec.ex.wanandroid.settings.mine.collection;

import com.fec.ex.wanandroid.base.BasePresenter;
import com.fec.ex.wanandroid.base.BaseView;
import com.fec.ex.wanandroid.settings.mine.collection.domain.model.CollectionList;

import java.util.List;

/**
 * Created by Fe2Cu on 07.07.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class CollectionContract {
    public interface View extends BaseView<CollectionContract.Presenter> {
        void showCollectionList(List<CollectionList.DatasBean> collectionList);

        void refreshData(List<CollectionList.DatasBean> collectionList);

        void showError(String msg);
    }

    public interface Presenter extends BasePresenter {
        void getCollectionList(boolean loadMore);
    }
}
