package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class pdf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        String url = getIntent().getStringExtra("pdf_url");
        WebView webView =findViewById(R.id.pdf);
        //WebView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient( new WebViewClient());
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" +url);
    }
}