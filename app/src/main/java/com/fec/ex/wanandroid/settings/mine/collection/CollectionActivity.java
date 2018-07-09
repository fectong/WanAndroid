package com.fec.ex.wanandroid.settings.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Fe2Cu on 07.10.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class MineActivity extends AppCompatActivity implements MineContract.View {
    private final String TAG = this.getClass().getName();
    private MineContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MinePresenter(this);
    }
}
