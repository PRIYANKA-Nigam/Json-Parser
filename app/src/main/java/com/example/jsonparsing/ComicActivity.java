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

public class ComicActivity extends AppCompatActivity {
    private static final String TAG = "Comic";
    RequestQueue requestQueue;
  ArrayList<ComicModel> list;
    RecyclerView recyclerView;
ComicAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic);
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
     list=new ArrayList<>();
        adapter=new ComicAdapter(ComicActivity.this,list);
        recyclerView.setAdapter(adapter);
//        callApi("https://run.mocky.io/v3/77e9bcca-3593-43a3-abae-6ccd1f1c153f");
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
            JSONArray movies = jsonObject.getJSONArray("comics");
            for (int i=0; i<movies.length(); i++){
                JSONObject childObj = movies.getJSONObject(i);
                String title = childObj.getString("title");
//                String overview = childObj.getString("url");
                String image = childObj.getString("imageUrl");
                //   textView.setText(title+""+overview);
//            ComicModel model = new ComicModel(image,title,  overview);
                ComicModel model = new ComicModel(image,title);
                 list.add(model);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }

}