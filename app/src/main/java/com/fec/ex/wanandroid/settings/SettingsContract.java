package com.fec.ex.wanandroid.settings;

import android.content.Context;

import com.fec.ex.wanandroid.base.BasePresenter;
import com.fec.ex.wanandroid.base.BaseView;

/**
 * Created by Fe2Cu on 07.07.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public interface SettingsContract {
    public interface View extends BaseView<SettingsContract.Presenter> {
        void init();

        void initSettings();

    }

    public interface Presenter extends BasePresenter {
        void signIn(Context context);

        void signOut();
    }
}
