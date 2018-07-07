package com.fec.ex.wanandroid.login;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.login.domain.LoginData;
import com.fec.ex.wanandroid.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener {

    private Context mContext;
    private LoginContract.Presenter mPresenter;
    private final String TAG = this.getClass().getName();

    private TextView mSectionSignIn;
    private TextView mSectionSignUp;
    private TextView mSignIn;
    private TextView mSignUp;
    private EditText mUserName;
    private EditText mPassword;
    private EditText mRePassword;
    private TextView mLater;

    private String name;
    private String password;
    private String rePassword;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        mPresenter = new LoginPresenter(this);
        init();
    }

    private void init() {
        mSectionSignIn = findViewById(R.id.sectionSignIN);
        mSectionSignUp = findViewById(R.id.sectionSignUP);
        mSignIn = findViewById(R.id.signIN);
        mSignUp = findViewById(R.id.signUP);
        mUserName = findViewById(R.id.etUserName);
        mPassword = findViewById(R.id.etPassword);
        mRePassword = findViewById(R.id.etRePassword);
        mLater = findViewById(R.id.later);

        mSectionSignIn.setOnClickListener(this);
        mSectionSignUp.setOnClickListener(this);
        mSignIn.setOnClickListener(this);
        mSignUp.setOnClickListener(this);
        mRePassword.setOnClickListener(this);
        mLater.setOnClickListener(this);
    }

    @Override
    public void initSign(LoginData loginData) {
        startActivity(new Intent(mContext, MainActivity.class));
    }

    @Override
    public void showError(String errorMsg) {
        snack(errorMsg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.later:
                startActivity(new Intent(mContext, MainActivity.class));
                break;
            case R.id.sectionSignIN:
                if (flag) {
                    mSignIn.setVisibility(View.VISIBLE);
                    mRePassword.setVisibility(View.GONE);
                    mSignUp.setVisibility(View.GONE);
                }
                flag = false;
                break;
            case R.id.sectionSignUP:
                if (!flag) {
                    mSignIn.setVisibility(View.GONE);
                    mRePassword.setVisibility(View.VISIBLE);
                    mSignUp.setVisibility(View.VISIBLE);
                }
                flag = true;
                break;
            case R.id.signIN:
                hideKeyboard();
                signIn();
                break;
            case R.id.signUP:
                hideKeyboard();
                signUp();
                break;
            case R.id.etPassword:
                mPassword.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                            if ((i == KeyEvent.KEYCODE_ENTER) || (flag && i == KeyEvent.KEYCODE_FORWARD)) {
                                hideKeyboard();
                                signIn();
                                return true;
                            }
                        }
                        return false;
                    }
                });
                break;
            case R.id.etRePassword:
                mRePassword.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                            if (i == KeyEvent.KEYCODE_ENTER) {
                                hideKeyboard();
                                signUp();
                                return true;
                            }
                        }
                        return false;
                    }
                });
                break;
        }
    }

    @Override
    public void signIn() {
        name = mUserName.getText().toString();
        password = mPassword.getText().toString();
        if (name != null && !name.equals("")) {
            if (password != null && !password.equals("")) {
                mPresenter.signIn(name, password);
            } else {
                snack(getString(R.string.password_can_not_blank));
            }
        } else {
            snack(getString(R.string.name_can_not_blank));
        }
    }

    @Override
    public void signUp() {
        name = mUserName.getText().toString();
        password = mPassword.getText().toString();
        rePassword = mRePassword.getText().toString();
        Log.d(TAG, "name: --" + name + "-");
        Log.d(TAG, "password: --" + password + "-");
        Log.d(TAG, "rePassword: --" + rePassword + "-");

        if (name != null && !name.equals("")) {
            if ((password != null && !password.equals("")) && (rePassword != null && !rePassword.equals(""))) {
                if (password.equals(rePassword)) {
                    mPresenter.signUp(name, password, rePassword);
                } else {
                    snack(getString(R.string.two_password_not_equal));
                }
            } else {
                snack(getString(R.string.password_can_not_blank));
            }
        } else {
            snack(getString(R.string.name_can_not_blank));
        }
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        assert inputManager != null;
        inputManager.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void snack(String msg) {
        Snackbar.make(mLater, msg, Snackbar.LENGTH_SHORT).setAction(R.string.ok, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }).show();
    }

}
