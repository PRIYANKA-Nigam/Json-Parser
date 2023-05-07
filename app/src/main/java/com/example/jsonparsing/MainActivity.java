package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsonparsing.JokesRiddle.JokeAdapter;
import com.example.jsonparsing.JokesRiddle.JokesModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Callapi" ;
    RequestQueue requestQueue;
ArrayList<JokesModel> arrayList; ArrayList<ComicModel> list;
RecyclerView recyclerView;
//TextView textView;
JokeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String link=getIntent().getStringExtra("url");
        String type= getIntent().getStringExtra("type");
        seeView(link);

    }

    private void seeView(String link) {
        requestQueue = Volley.newRequestQueue(this);
        recyclerView= findViewById(R.id.rec);
     //   textView =findViewById(R.id.textView3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<>();
        adapter=new JokeAdapter(MainActivity.this,arrayList);
        recyclerView.setAdapter(adapter);
//        callApi("https://run.mocky.io/v3/77e9bcca-3593-43a3-abae-6ccd1f1c153f");
        callApi(link);
    }

    private void callApi(String s) {
        StringRequest stringRequest =new StringRequest(Request.Method.GET,s,response -> {
            Log.d(TAG, "callApi: "+ response);
            extract(response);

        },error -> Log.d("error",error.toString()));
               requestQueue.add(stringRequest);
    }


    private void extract(String response) {
       try {
           JSONObject jsonObject = new JSONObject(response);
           JSONArray movies = jsonObject.getJSONArray("jokes");
           for (int i=0; i<movies.length(); i++){
               JSONObject childObj = movies.getJSONObject(i);
               String title = childObj.getString("question");
               String overview = childObj.getString("answer");
            //   textView.setText(title+""+overview);
              JokesModel model = new JokesModel(title,  overview);
             arrayList.add(model);
           }
           adapter.notifyDataSetChanged();
           } catch (Exception jsonException) {
           jsonException.printStackTrace();
       }
    }
}