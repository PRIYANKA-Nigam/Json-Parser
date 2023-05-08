package com.example.jsonparsing.Singers;

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

public class SingerActivity extends AppCompatActivity {
    private static final String TAG = "singers";
    RequestQueue requestQueue;
    ArrayList<SingerModal> arrayList;
    RecyclerView recyclerView;
    SingerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer);
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
        adapter=new SingerAdapter(SingerActivity.this,arrayList);
        recyclerView.setAdapter(adapter);
//        int i = adapter.getItemCount();
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
            JSONArray movies = jsonObject.getJSONArray("singers");
            for (int i=0; i<movies.length(); i++){   String gen ="";
                JSONObject childObj = movies.getJSONObject(i);
                String author = childObj.getString("name");
                JSONArray title = childObj.getJSONArray("genres");
                for(int j=0;j<title.length();j++){
                  String generes = (String) title.get(j);
                  gen+=generes+"\n";
                }
             JSONObject web = childObj.getJSONObject("followers");
                String followers=web.getString("total");
               JSONArray image = childObj.getJSONArray("images");
             JSONObject img = (JSONObject) image.get(0);
             String imgLink = img.getString("url");
             JSONObject j=childObj.getJSONObject("external_urls");
             String link=j.getString("spotify");
//             SingerModal modal = new SingerModal(author,gen,followers,imgLink);
                SingerModal modal = new SingerModal(author,followers,link,imgLink,gen);
                arrayList.add(modal);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }
}