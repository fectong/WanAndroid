package com.fec.ex.wanandroid.settings;

/**
 * Created by Fe2Cu on 07.07.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class SettingsPresenter implements SettingsContract.Presenter {
    private SettingsContract.View mView;

    public SettingsPresenter(SettingsContract.View view) {
        mView = view;
    }
}
