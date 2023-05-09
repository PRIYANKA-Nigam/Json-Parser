package com.example.jsonparsing.BollywoodQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jsonparsing.CategoryActivity;
import com.example.jsonparsing.R;

public class QuizActivity extends AppCompatActivity {
TextView textView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        textView=findViewById(R.id.textView40);
        textView.setText("correct : "+getIntent().getStringExtra("correct")+"\n"+
               "wrong : "+ getIntent().getStringExtra("wrong"));
        button=findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizAdapter.c=0;QuizAdapter.w=0;
                finish();
            }
        });
    }

    public void exit(View view) {
        startActivity(new Intent(this, CategoryActivity.class));
        finish();
    }
}