package com.example.jsonparsing.Billionaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.jsonparsing.R;

import java.util.ArrayList;

public class BillionaireViewActivity2 extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billionaire_view2);
        t1=findViewById(R.id.textView32);
        t2=findViewById(R.id.textView33);
        t3=findViewById(R.id.textView34);
        t4=findViewById(R.id.textView35);
        t5=findViewById(R.id.textView36);
        t6=findViewById(R.id.textView37);
        t7=findViewById(R.id.t1);
        t8=findViewById(R.id.t2);
        t9=findViewById(R.id.t3);
        t10=findViewById(R.id.t);
        t1.setText(getIntent().getStringExtra("name"));
        t2.setText("Category : "+getIntent().getStringExtra("indus"));
        t3.setText("Worth : " +getIntent().getStringExtra("worth"));
        String b = getIntent().getStringExtra("bulk");
        String []a=b.split("[|]");
        ArrayList<String> arr = new ArrayList<>();
        for(String str:a)
            arr.add(str);
        t4.setText("Country : "+arr.get(0));
        t5.setText("State : "+arr.get(1));
        t9.setText("City : "+arr.get(2));
        t7.setText("Company : "+arr.get(3));
        t8.setText("Title : "+arr.get(5));
        t6.setText("Bio : "+arr.get(4));
        t10.setText("Age : "+arr.get(6));


    }
}