package com.example.jsonparsing.Comics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.jsonparsing.R;

public class ComicViewActivity extends AppCompatActivity {
    WebView webView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_view);
        webView=findViewById(R.id.full);
        textView=findViewById(R.id.tb1);
        String title = getIntent().getStringExtra("title");
        textView.setText(title);
        String link = getIntent().getStringExtra("comic");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
    }
}