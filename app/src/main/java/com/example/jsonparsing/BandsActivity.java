package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsonparsing.Actor.ActorActivity;
import com.example.jsonparsing.Actor.ActorAdapter;
import com.example.jsonparsing.Actor.ActorModal;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class BandsActivity extends AppCompatActivity {
    private static final String TAG = "bands";
    RequestQueue requestQueue;
    ArrayList<String> arrayList;
    ListView listView;
  ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bands);
        String link=getIntent().getStringExtra("url");
        String type= getIntent().getStringExtra("type");
        seeView(link);
    }

    private void seeView(String link) {
        requestQueue = Volley.newRequestQueue(this);
        listView=findViewById(R.id.ll);
        arrayList=new ArrayList<>();
        adapter=new ArrayAdapter(BandsActivity.this,R.layout.names,arrayList);
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
            JSONArray movies = jsonObject.getJSONArray("bands");
            for (int i=0; i<movies.length(); i++){
                JSONObject childObj = movies.getJSONObject(i);
                String author = childObj.getString("name");
                arrayList.add((i+1)+".  "+author);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }
}