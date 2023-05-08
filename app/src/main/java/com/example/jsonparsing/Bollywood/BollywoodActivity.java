package com.example.jsonparsing.Bollywood;

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

public class BollywoodActivity extends AppCompatActivity {
    private static final String TAG = "bollywood" ;
    RequestQueue requestQueue;
    ArrayList<BollywoodModel> arrayList;
    RecyclerView recyclerView;
    BollywoodAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bollywood);
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
        adapter=new BollywoodAdapter(BollywoodActivity.this,arrayList);
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
            JSONArray movies = jsonObject.getJSONArray("bollywood");
            for (int i=0; i<movies.length(); i++){
                String gen="";String actor="";
                JSONObject childObj = movies.getJSONObject(i);
                String date = childObj.getString("Year");
                String title = childObj.getString("title");
               JSONArray genre = childObj.getJSONArray("genres");
               for(int j=0;j<genre.length();j++){
                   gen+=genre.getString(j)+",";
               }
               JSONArray actors = childObj.getJSONArray("Actors");
                for(int k=0;k<actors.length();k++){
                 actor=actors.getString(k)+",";
                }
                String plot = childObj.getString("storyline");
                String poster = childObj.getString("posterurl");
                BollywoodModel model = new BollywoodModel(title,date,gen,plot,actor,poster);
                arrayList.add(model);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }
}