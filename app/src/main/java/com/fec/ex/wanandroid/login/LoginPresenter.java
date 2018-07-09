package com.fec.ex.wanandroid.login;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.base.App;
import com.fec.ex.wanandroid.base.BaseBean;
import com.fec.ex.wanandroid.helper.Constants;
import com.fec.ex.wanandroid.helper.RetrofitManager;
import com.fec.ex.wanandroid.helper.Utils;
import com.fec.ex.wanandroid.login.domain.LoginData;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class LoginPresenter implements LoginContract.Presenter {

    private static final String TAG = "LoginPresenter";

    private LoginContract.View mView;
    private RetrofitManager mClient;

    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
        mClient = RetrofitManager.instance();
    }

    @Override
    public void logIn(String name, String password) {

        if (TextUtils.isEmpty(name)) {
            mView.showError(App.getContext().getString(R.string.name_can_not_blank));
            if (TextUtils.isEmpty(password)) {
                mView.showError(App.getContext().getString(R.string.password_can_not_blank));
            }
            return;
        }

        mClient.getWanService()
                .login(name, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<LoginData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<LoginData> loginBaseBean) {
                        if (loginBaseBean.getErrorCode() == Constants.SUCCESS) {
                            Utils.setLogin(true);
                            mView.initSign();
                        } else {
                            Utils.setLogin(false);
                            mView.showError(loginBaseBean.getErrorMsg());
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

    @Override
    public void register(String name, String password, String repassword) {

        if (TextUtils.isEmpty(name)) {
            mView.showError(App.getContext().getString(R.string.name_can_not_blank));
            if (TextUtils.isEmpty(password) || TextUtils.isEmpty(repassword)) {
                mView.showError(App.getContext().getString(R.string.password_can_not_blank));
                if (!TextUtils.equals(password, repassword)){
                    mView.showError(App.getContext().getString(R.string.two_password_not_equal));
                }
            }
            return;
        }

        mClient.getWanService()
                .register(name, password, repassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<LoginData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<LoginData> loginBaseBean) {
                        if (loginBaseBean.getErrorCode() == Constants.SUCCESS) {
                            Utils.setLogin(true);
                            mView.initSign();
                        } else {
                            Utils.setLogin(false);
                            mView.showError(loginBaseBean.getErrorMsg());
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
