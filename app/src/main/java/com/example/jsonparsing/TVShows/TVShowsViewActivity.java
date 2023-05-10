package com.example.jsonparsing.TVShows;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.jsonparsing.R;

public class TVShowsViewActivity extends AppCompatActivity {
TextView t1,t2,t3,t4,t5;
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_shows_view);
        webView=findViewById(R.id.web);
        t1=findViewById(R.id.textView42);
        t2=findViewById(R.id.textView43);
        t3=findViewById(R.id.textView44);
        t4=findViewById(R.id.textView45);
        t5=findViewById(R.id.textView46);
        t1.setText(getIntent().getStringExtra("title"));
        t2.setText("Genres : "+getIntent().getStringExtra("genre"));
        t3.setText("Ratings : "+getIntent().getStringExtra("rating"));
        t4.setText("Language : "+getIntent().getStringExtra("language"));
        t5.setText("Summary : "+  Html.fromHtml(getIntent().getStringExtra("summary"))); //to remove all the html tags
        String link=getIntent().getStringExtra("web");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);

    }
}