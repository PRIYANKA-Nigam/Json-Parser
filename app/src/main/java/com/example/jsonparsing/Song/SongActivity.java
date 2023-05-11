package com.example.jsonparsing.Song;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsonparsing.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

public class SongActivity extends AppCompatActivity {
TextView textView;
RecyclerView recyclerView;
    ArrayList<songModel> arrayList;
    RequestQueue requestQueue;
    SongAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        String link=getIntent().getStringExtra("url");
        String type= getIntent().getStringExtra("type");
        seeView(link);
        textView=findViewById(R.id.textView19);
        textView.setText(type);

    }


    private void seeView(String link) {
        requestQueue = Volley.newRequestQueue(this);
        recyclerView= findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<>();
        adapter=new SongAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);

        callApi(link);
    }

    private void callApi(String link) {
        StringRequest stringRequest =new StringRequest(Request.Method.GET,link, response -> {
            extract(response);

        },error -> Log.d("error",error.toString()));
        requestQueue.add(stringRequest);
    }

    private void extract(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray movies = jsonObject.getJSONArray("songs");
            for (int i=0; i<movies.length(); i++){
                JSONObject childObj = movies.getJSONObject(i);
                String title= childObj.getString("title");
                String image = childObj.getString("artwork");
                String url =childObj.getString("url");
              songModel model = new songModel(image,url,title);
                arrayList.add(model);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }
}