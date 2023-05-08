package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SportsActivity extends AppCompatActivity {
    private static final String TAG = "sports";
    RequestQueue requestQueue;
TextView textView;
ListView listView;
ArrayAdapter<String> adapter;
ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        textView = findViewById(R.id.textView20);
        String link=getIntent().getStringExtra("url");
        String type= getIntent().getStringExtra("type");
        textView.setText(type);
        seeView(link);
    }

    private void seeView(String link) {
        requestQueue = Volley.newRequestQueue(this);
        listView = findViewById(R.id.ll);
        arrayList=new ArrayList<String>();
        adapter=new ArrayAdapter(SportsActivity.this,R.layout.names,arrayList);
        listView.setAdapter(adapter);
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
            JSONArray movies = jsonObject.getJSONArray("sports");
            for (int i=0; i<movies.length(); i++){
             String name = (i+1)+". "+movies.getString(i);
                arrayList.add(name);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }
}