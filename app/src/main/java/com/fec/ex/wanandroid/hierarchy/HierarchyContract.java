package com.fec.ex.wanandroid.hierarchy;

import com.fec.ex.wanandroid.base.BasePresenter;
import com.fec.ex.wanandroid.base.BaseView;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public interface HierarchyContract {

    public interface View extends BaseView<Presenter> {

    }

    public interface Presenter extends BasePresenter {

    }
}
