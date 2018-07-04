package com.fec.ex.wanandroid.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fec.ex.wanandroid.R;
import com.fec.ex.wanandroid.main.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;

        TextView tvLater = findViewById(R.id.later);
        tvLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, MainActivity.class));
            }
        });
    }
}
