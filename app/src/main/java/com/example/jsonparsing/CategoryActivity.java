package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jsonparsing.Actor.ActorActivity;
import com.example.jsonparsing.Bollywood.BollywoodActivity;
import com.example.jsonparsing.Comics.ComicActivity;
import com.example.jsonparsing.Hollywood.HollywoodActivity;
import com.example.jsonparsing.JokesRiddle.MainActivity;
import com.example.jsonparsing.Netflix.NetflixActivity;
import com.example.jsonparsing.Novel.NovelActivity;
import com.example.jsonparsing.Singers.SingerActivity;
import com.example.jsonparsing.Youtube.YoutubeActivity;

public class CategoryActivity extends AppCompatActivity {
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        t1=findViewById(R.id.textView3);
        t2=findViewById(R.id.textView4);
        t3=findViewById(R.id.textView5);
        t4=findViewById(R.id.textView6);
        t5=findViewById(R.id.textView7);
        t6=findViewById(R.id.textView8);
        t7=findViewById(R.id.textView9);
        t8=findViewById(R.id.textView10);
        t9=findViewById(R.id.textView11);
        t10=findViewById(R.id.textView12);
        t11=findViewById(R.id.textView13);
        t12=findViewById(R.id.textView14);
        t13=findViewById(R.id.textView15);
        t14=findViewById(R.id.textView16);
        t15=findViewById(R.id.textView17);
        t16=findViewById(R.id.textView18);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this, MainActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/80cd8538-efdf-443d-b29e-549410d25dd5");
                intent.putExtra("type","joke");  //not working
                startActivity(intent);

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this,MainActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/e711407d-4a6f-4248-a345-af04e0289260");
                intent.putExtra("type","riddle");
                startActivity(intent);

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this, ComicActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/e4ebdad6-7562-49fb-b901-779efea10628");
                intent.putExtra("type","comic"); //not working
                startActivity(intent);

            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this, NovelActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/f842484a-b05d-45bc-a59a-16279f471e71");
                intent.putExtra("type","novel");
                startActivity(intent);

            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this,SportsActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/c274a68b-c01a-4dba-91a0-5c92e0a97b56");
                intent.putExtra("type","sports");
                startActivity(intent);

            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this,MainActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/08675adb-ab7c-4c77-93c6-31285a1178a9");
                intent.putExtra("type","dance"); //not working
                startActivity(intent);

            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this, ActorActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/d28980f5-9c2f-4433-bf96-4d6ce3ef1aae");
                intent.putExtra("type","actor");
                startActivity(intent);

            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this, SingerActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/5d5760bd-d8b3-43b9-bfbf-b3fae685ae86");
                intent.putExtra("type","singer");
                startActivity(intent);

            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this, YoutubeActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/a69a787f-0c45-4049-8bc0-0dea89a3181e");
                intent.putExtra("type","youtube"); //numbers are not coming
                startActivity(intent);

            }
        });
        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this, NetflixActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/09dd541f-dae4-4c3c-a18f-8a66e1a867d5");
                intent.putExtra("type","netflix");//numbers are not coming
                startActivity(intent);

            }
        });
        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this, HollywoodActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/d1837bd5-e090-425a-9ddc-e2b2ef6f86a7");
                intent.putExtra("type","hollywood"); //not working
                startActivity(intent);

            }
        });
        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this, BollywoodActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/1d9bc479-a19d-44ed-aaeb-ef95245a378a");
                intent.putExtra("type","bollywood"); //not working
                startActivity(intent);

            }
        });
        t13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this,HollywoodActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/90ccd1e4-2d16-4f57-9cf1-a1825287e443");
                startActivity(intent);

            }
        });
        t14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this,MainActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/486962d6-0f52-45a3-85b1-1a0b639f74c3");
                startActivity(intent);

            }
        });
        t15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this,MainActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/19ecad85-30c8-40cb-a135-8d235351f8d0");
                startActivity(intent);

            }
        });
        t16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this,MainActivity.class);
                intent.putExtra("url","https://run.mocky.io/v3/6376582a-eef7-4a62-8a4b-912862addb0d");
                startActivity(intent);

            }
        });
    }
}