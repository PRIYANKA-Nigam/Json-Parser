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
import com.example.jsonparsing.Bollywood.BollywoodActivity;
import com.example.jsonparsing.Bollywood.BollywoodAdapter;
import com.example.jsonparsing.Bollywood.BollywoodModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TVshowsActivity extends AppCompatActivity {
    private static final String TAG = "tvshows";
    RequestQueue requestQueue;
    ArrayList<TVShowsModel> arrayList;
    RecyclerView recyclerView;
    TVShowsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_vshows);
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
        adapter=new TVShowsAdapter(this,arrayList);
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
            JSONArray movies = jsonObject.getJSONArray("tvShows");
            for (int i=0; i<movies.length(); i++){
                String gen="";String actor="";
                JSONObject childObj = movies.getJSONObject(i);
                String language = childObj.getString("language");
                String title = childObj.getString("name");
                JSONArray genre = childObj.getJSONArray("genres");
                for(int j=0;j<genre.length();j++){
                    gen+=genre.getString(j)+",";
                }
                JSONObject actors = childObj.getJSONObject("rating");
                String rating=actors.getString("average");
                JSONObject c=childObj.getJSONObject("network");
                JSONObject d=c.getJSONObject("country");
                String country=d.getString("name");
                String plot = childObj.getString("summary");
                JSONObject object=childObj.getJSONObject("image");
                String image=object.getString("original");
                String web =childObj.getString("url");
            TVShowsModel model = new TVShowsModel(title,language,gen,rating,country,plot,image,web);
                arrayList.add(model);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }
}