package com.example.jsonparsing.Youtube;

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

public class YoutubeActivity extends AppCompatActivity {
    private static final String TAG = "youtube";
    RequestQueue requestQueue;
    ArrayList<YoutubeModel> arrayList;
    RecyclerView recyclerView;
   YoutubeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
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
        adapter=new YoutubeAdapter(YoutubeActivity.this,arrayList);
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
            JSONArray movies = jsonObject.getJSONArray("youtube");
            for (int i=0; i<movies.length(); i++){
                JSONObject childObj = movies.getJSONObject(i);
                String date = childObj.getString("date_published");
                String[] d=date.split("T");
                String dates=d[0];
                String title = childObj.getString("title");
                String web = childObj.getString("url");
                JSONObject obj=childObj.getJSONObject("author");
                String name=obj.getString("name");
                //   textView.setText(title+""+overview);
             YoutubeModel model = new YoutubeModel(title,dates,web,name);
                arrayList.add(model);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }
}