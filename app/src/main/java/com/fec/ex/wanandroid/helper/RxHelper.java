package com.fec.ex.wanandroid.helper;

import com.fec.ex.wanandroid.base.BaseBean;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Fe2Cu on 07.11.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class RxHelper {

    public static <T> ObservableTransformer<T, T> io2main() {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}
