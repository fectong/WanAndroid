package com.fec.ex.wanandroid.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.fec.ex.wanandroid.R;

public class ArticleActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        String URL = getIntent().getStringExtra("URL");
        mWebView = findViewById(R.id.webView);
        mWebView.loadUrl(URL);
    }

}
