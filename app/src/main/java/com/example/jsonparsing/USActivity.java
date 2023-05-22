package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsonparsing.Population.PopulationAdapter;
import com.example.jsonparsing.Population.PopulationModel;
import com.example.jsonparsing.Population.WorldActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class USActivity extends AppCompatActivity {
    ListView listView;   RequestQueue requestQueue;
    PopulationAdapter adapter;
    ArrayList<PopulationModel> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_s);
        listView = findViewById(R.id.ll);
        String link=getIntent().getStringExtra("url");
        seeView(link);
    }

    private void seeView(String link) {
        requestQueue = Volley.newRequestQueue(this);
        listView=findViewById(R.id.ll);
        arrayList=new ArrayList<>();
        adapter=new PopulationAdapter(USActivity.this,arrayList);
        listView.setAdapter(adapter);
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
            JSONArray movies = jsonObject.getJSONArray("data");
            for (int i=0; i<movies.length(); i++){
                JSONObject childObj = movies.getJSONObject(i);
                String author = childObj.getString("State");
                String title = childObj.getString("Population");
                PopulationModel model = new PopulationModel(author,title);
                arrayList.add(model);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }
}