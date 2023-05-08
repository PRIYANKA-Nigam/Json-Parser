package com.example.jsonparsing.Hollywood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jsonparsing.R;

public class HollywoodViewActivity extends AppCompatActivity {
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hollywood_view);
        imageView=findViewById(R.id.imageView2);
        t1=findViewById(R.id.textView22);
        t2=findViewById(R.id.textView23);
        t3=findViewById(R.id.textView24);
        t4=findViewById(R.id.textView25);
        t5=findViewById(R.id.textView26);
        t6=findViewById(R.id.textView27);
        t7=findViewById(R.id.textView28);
        t8=findViewById(R.id.textView29);
        t9=findViewById(R.id.textView30);
        t10=findViewById(R.id.textView31);
      t1.setText(getIntent().getStringExtra("title"));
      t2.setText(getIntent().getStringExtra("year"));
      t3.setText(getIntent().getStringExtra("genre"));
      t4.setText(getIntent().getStringExtra("director"));
      t5.setText(getIntent().getStringExtra("writer"));
      t6.setText(getIntent().getStringExtra("actor"));
      t7.setText(getIntent().getStringExtra("language"));
      t8.setText(getIntent().getStringExtra("country"));
      t9.setText(getIntent().getStringExtra("awards"));
      t10.setText(getIntent().getStringExtra("plot"));
      String poster=getIntent().getStringExtra("image");
        Glide.with(this).load(poster).into(imageView);
    }
}