package com.example.jsonparsing.Bollywood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jsonparsing.R;

public class BollywoodViewActivity extends AppCompatActivity {
TextView t1,t2,t3,t4,t5;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bollywood_view);
        t1=findViewById(R.id.textView47);
        t2=findViewById(R.id.textView48);
        t3=findViewById(R.id.textView49);
        t4=findViewById(R.id.textView50);
        t5=findViewById(R.id.textView51);
        imageView=findViewById(R.id.imageView3);
        t1.setText(getIntent().getStringExtra("title"));
        t2.setText("Released Year : "+getIntent().getStringExtra("year"));
        t3.setText("Actors : "+getIntent().getStringExtra("actor"));
        t4.setText("Genres : "+getIntent().getStringExtra("genre"));
        t5.setText("StoryLine : "+getIntent().getStringExtra("story"));
        String img=getIntent().getStringExtra("img");
        Glide.with(this).load(img).into(imageView);



    }
}