package com.fec.ex.wanandroid.base;

/**
 * Created by Fe2Cu on 06.29.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class BaseBean<T> {

    private int errorCode;
    private String errorMsg;
    private T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
