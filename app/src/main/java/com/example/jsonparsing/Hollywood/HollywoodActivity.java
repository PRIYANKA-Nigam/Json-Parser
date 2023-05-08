package com.example.jsonparsing.Hollywood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsonparsing.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class HollywoodActivity extends AppCompatActivity {
    private static final String TAG = "hollywood";
    RequestQueue requestQueue;
    ArrayList<HollywoodModel> arrayList;
    RecyclerView recyclerView;
    HollywoodAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hollywood);
        String link=getIntent().getStringExtra("url");
        String type= getIntent().getStringExtra("type");
        seeView(link);
    }

    private void seeView(String link) {
        requestQueue = Volley.newRequestQueue(this);
        recyclerView= findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<>();
        adapter=new HollywoodAdapter(HollywoodActivity.this,arrayList);
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
            JSONArray movies = jsonObject.getJSONArray("hollywood");
            for (int i=0; i<movies.length(); i++){
                JSONObject childObj = movies.getJSONObject(i);
                String date = childObj.getString("Year");
                String title = childObj.getString("title");
                String genre = childObj.getString("Genre");
                String director= childObj.getString("Director");
                String writer = childObj.getString("Writer");
                String actors = childObj.getString("Actors");
                String plot = childObj.getString("Plot");
                String language = childObj.getString("Language");
                String country = childObj.getString("Country");
                String awards = childObj.getString("Awards");
                String poster = childObj.getString("Poster");
             HollywoodModel model = new HollywoodModel(title,date,genre,director,writer,actors,plot,language,country,awards,poster);
                arrayList.add(model);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }
}