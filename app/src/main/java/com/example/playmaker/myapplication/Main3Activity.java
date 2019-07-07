package com.example.playmaker.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        WebView webView = (WebView) findViewById(R.id.webview);
        Intent data = getIntent();
        int page = data.getExtras().getInt("Home2");
        page++;
        webView.loadUrl("file:///android_asset/" + page + ".html");
    }
}
