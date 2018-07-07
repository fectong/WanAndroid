package com.fec.ex.wanandroid.helper.cookie;

import com.fec.ex.wanandroid.base.App;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by Fe2Cu on 07.08.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class CookieManager implements CookieJar {

    private static final PersistentCookieStore COOKIE_STORE = new PersistentCookieStore(App.getContext());

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies.size() > 0) {
            for (Cookie item : cookies) {
                COOKIE_STORE.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = COOKIE_STORE.get(url);
        return cookies;
    }
}
