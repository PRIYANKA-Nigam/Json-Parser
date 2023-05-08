package com.example.jsonparsing.Dance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.jsonparsing.R;

public class DanceViewActivity extends AppCompatActivity {
    WebView webView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance_view);
        textView=findViewById(R.id.textView21);
        webView=findViewById(R.id.full);
        String link=getIntent().getStringExtra("link");
        String title=getIntent().getStringExtra("title");
        textView.setText(title);
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
    }
}