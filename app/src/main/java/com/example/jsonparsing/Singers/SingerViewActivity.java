package com.example.jsonparsing.Singers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.jsonparsing.R;

public class SingerViewActivity extends AppCompatActivity {
TextView textView;
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer_view);
        textView=findViewById(R.id.textView19);
        webView=findViewById(R.id.visible);
        String link=getIntent().getStringExtra("link");
        String title=getIntent().getStringExtra("title");
        textView.setText(title);
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
    }
}