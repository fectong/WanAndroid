package com.fec.ex.wanandroid.helper;

import com.fec.ex.wanandroid.api.WanApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class RetrofitManager {

    private static final String BASE_URL = "http://www.wanandroid.com/";
    private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

    private WanApi wanService;

    public WanApi getWanService() {
        return wanService;
    }

    public static RetrofitManager instance() {
        return Singleton.instance;
    }

    private RetrofitManager() {
        Gson gson =
                new GsonBuilder()
                        .setDateFormat(DATE_FORMAT)
                        .create();

        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();

        wanService = retrofit.create(WanApi.class);
    }

    private static class Singleton {
        private static RetrofitManager instance = new RetrofitManager();
    }
}
