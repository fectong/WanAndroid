package com.fec.ex.wanandroid.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Fe2Cu on 07.08.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class App extends Application {
    private static App INSTANCE;

    public static synchronized App getInstance() {
        return INSTANCE;
    }

    public static Context getContext() {
        return getInstance().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        GlideApp.get(this).clearMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            GlideApp.get(this).clearMemory();
        }
        GlideApp.get(this).trimMemory(level);
    }
}
