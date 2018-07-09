package com.fec.ex.wanandroid.settings.mine.navigation;

/**
 * Created by Fe2Cu on 07.10.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class NavigationPresenter implements NavigationContract.Presenter {
    private NavigationContract.View mView;

    public NavigationPresenter(NavigationContract.View view) {
        mView = view;
    }
}
