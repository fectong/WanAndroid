package com.fec.ex.wanandroid.helper;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.base.App;
import com.fec.ex.wanandroid.main.ArticleActivity;

/**
 * Created by Fe2Cu on 07.08.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class Utils {

    public static void snack(Activity activity, String msg, @Nullable View.OnClickListener listener) {
        Snackbar.make(activity.getWindow().getDecorView(), msg, Snackbar.LENGTH_SHORT).setAction(R.string.ok, listener).show();
    }

    public static boolean isLogin() {
        boolean loginStatus;
        SharedPreferences sp = App.getContext().getSharedPreferences(Constants.PREFS_LOGIN, 0);
        loginStatus = sp.getBoolean(Constants.LOGIN_STATUS, false);
        return loginStatus;
    }

    public static void setLogin(boolean loginStatus) {
        SharedPreferences sp = App.getContext().getSharedPreferences(Constants.PREFS_LOGIN, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(Constants.LOGIN_STATUS, loginStatus);
        editor.commit();
    }

    public static void toArticleView(Context context, String url, String title) {
        Intent intent = new Intent(context, ArticleActivity.class);
        intent.putExtra("URL", url);
        intent.putExtra("TITLE", title);
        context.startActivity(intent);
    }

    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        return connectivityManager.getActiveNetworkInfo() != null;
    }

}
