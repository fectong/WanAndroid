package com.fec.ex.wanandroid.base;

/**
 * Created by Fe2Cu on 07.01.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
