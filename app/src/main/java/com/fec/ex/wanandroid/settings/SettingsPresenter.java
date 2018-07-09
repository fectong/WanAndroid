package com.fec.ex.wanandroid.settings;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.fec.ex.wanandroid.helper.Utils;
import com.fec.ex.wanandroid.helper.cookie.CookieManager;
import com.fec.ex.wanandroid.login.LoginActivity;

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

    @Override
    public void signIn(Context context) {
        Log.d("Settings", "signIn: YES");
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    public void signOut() {
        Log.d("Settings", "signOut: YES");
        Utils.setLogin(false);
        CookieManager.clearAllCookies();
        mView.initSettings();
    }
}
