package com.example.jsonparsing.BollywoodQuiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsonparsing.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class BollywoodQuizActivity extends AppCompatActivity {
    private static final String TAG = "quiz";
    TextView textView;
    ArrayList<Question> arrayList;
    RequestQueue requestQueue;
RecyclerView recyclerView;
QuizAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bollywood_quiz);
        String link=getIntent().getStringExtra("url");
        String type= getIntent().getStringExtra("type");
        seeView(link);
        textView=findViewById(R.id.textView41);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BollywoodQuizActivity.this,QuizActivity.class);
                intent.putExtra("correct",String.valueOf(QuizAdapter.c));
                intent.putExtra("wrong",String.valueOf(QuizAdapter.w));
                startActivity(intent);
            }
        });
    }



    private void seeView(String link) {
        requestQueue = Volley.newRequestQueue(this);
        recyclerView= findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<>();
        adapter=new QuizAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);
        callApi(link);
    }

    private void callApi(String link) {
        StringRequest stringRequest =new StringRequest(Request.Method.GET,link, response -> {
            Log.d(TAG, "callApi: "+ response);
            extract(response);

        },error -> Log.d("error",error.toString()));
        requestQueue.add(stringRequest);
    }

    private void extract(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray movies = jsonObject.getJSONArray("singerQuiz");
            for (int i=0; i<movies.length(); i++){
                JSONObject childObj = movies.getJSONObject(i);
                String ques= childObj.getString("que");
                String ans1 = childObj.getString("opt1");
                String ans2 =childObj.getString("opt2");
                String ans3 =childObj.getString("opt3");
                String ans4 = childObj.getString("opt4");
                String correct = childObj.getString("ans");
              Question model = new Question(ques,ans1,ans2,ans3,ans4,correct);
                arrayList.add(model);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }

}