package com.fec.ex.wanandroid.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.util.Log;
import android.view.View;

import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.helper.Utils;

/**
 * Created by Fe2Cu on 07.07.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class SettingsFragment extends PreferenceFragmentCompat implements SettingsContract.View, SharedPreferences.OnSharedPreferenceChangeListener {
    private final String TAG = this.getClass().getName();
    private SettingsContract.Presenter mPresenter;
    public static final String KEY_USER_INFO = "user_info";
    public static final String KEY_SWITCH_STYLE = "switch_style_mode";
    public static final String KEY_SIGN = "sign";
    private boolean status;
    private Preference mUserInfo;
    private Preference mSign;

    public static SettingsFragment getInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.reference_settings, rootKey);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initSettings();
        initListener();
    }

    @Override
    public void init() {
        mPresenter = new SettingsPresenter(this);
        mUserInfo = findPreference(KEY_USER_INFO);
        mSign = findPreference(KEY_SIGN);
    }

    @Override
    public void initSettings() {
        status = Utils.isLogin();

        mUserInfo.setDefaultValue(status);
        mSign.setDefaultValue(status);
        mUserInfo.setSummary(status ? R.string.online : R.string.offline);
        mSign.setTitle(status ? R.string.sign_out : R.string.sign_in);
    }

    private void initListener() {
        mSign.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                if (status) {
                    Snackbar.make(getView(), "Sign OUT?", Snackbar.LENGTH_SHORT)
                            .setAction(R.string.yes, new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    mPresenter.signOut();
                                }
                            }).show();
                } else {
                    Snackbar.make(getView(), "Sign IN?", Snackbar.LENGTH_SHORT)
                            .setAction(R.string.yes, new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    mPresenter.signIn(getContext());
                                }
                            }).show();
                }
                return true;
            }
        });
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

}
