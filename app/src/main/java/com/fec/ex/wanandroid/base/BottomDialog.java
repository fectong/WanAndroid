package com.fec.ex.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fec.ex.wanandroid.R;

/**
 * Created by Fe2Cu on 07.10.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class BottomDialog extends BottomSheetDialogFragment {

    private TextView mTvTitle;
    private TextView mTvYes;
    private TextView mTvNo;

    private String mTitle;

    public static BottomDialog newInstance() {
        return new BottomDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(@NonNull View view) {
        mTitle = getArguments().getString("TITLE");
        mTvTitle = view.findViewById(R.id.tvTitle);
        mTvYes = view.findViewById(R.id.tvYes);
        mTvNo = view.findViewById(R.id.tvNo);
        if (!TextUtils.isEmpty(mTitle)) {
            mTvTitle.setText(mTitle);
        }

    }

}
