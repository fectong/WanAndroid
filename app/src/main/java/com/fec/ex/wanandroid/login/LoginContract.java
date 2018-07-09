package com.fec.ex.wanandroid.login;

import com.fec.ex.wanandroid.base.BasePresenter;
import com.fec.ex.wanandroid.base.BaseView;
import com.fec.ex.wanandroid.login.domain.LoginData;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public interface LoginContract {

    public interface View extends BaseView<Presenter> {
        void initSign();

        void showError(String errorMsg);

        void signIn();

        void signUp();
    }

    public interface Presenter extends BasePresenter {

        void logIn(String name, String password);

        void register(String name, String password, String repassword);

    }
}
