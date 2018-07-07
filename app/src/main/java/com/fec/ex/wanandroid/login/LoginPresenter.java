package com.fec.ex.wanandroid.login;

import com.fec.ex.wanandroid.base.BaseBean;
import com.fec.ex.wanandroid.base.Constants;
import com.fec.ex.wanandroid.helper.RetrofitManager;
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

    private LoginContract.View mView;
    private RetrofitManager mClient;
    private static final String TAG = "LoginPresenter";

    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
        mClient = RetrofitManager.instance();
    }

    @Override
    public void signIn(String name, String password) {
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
                        if (loginBaseBean.getErrorCode() == Constants.SUCCESS){
                            mView.initSign(loginBaseBean.getData());
                        } else {
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
    public void signUp(String name, String password, String repassword) {
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
                        if (loginBaseBean.getErrorCode() == Constants.SUCCESS){
                            mView.initSign(loginBaseBean.getData());
                        } else {
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
