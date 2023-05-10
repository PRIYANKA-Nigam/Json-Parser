package com.example.jsonparsing.Dance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsonparsing.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class DanceActivity extends AppCompatActivity {
    private static final String TAG = "DanceActivity";
    RequestQueue requestQueue;
    ArrayList<DanceModel> arrayList;
    RecyclerView recyclerView;
    DanceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance);
        String link=getIntent().getStringExtra("url");
        Log.d(TAG, "onCreate: "+ link);
//        String type= getIntent().getStringExtra("type");
        seeView(link);
    }

    private void seeView(String link) {
        requestQueue = Volley.newRequestQueue(this);
        recyclerView= findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<>();
        adapter=new DanceAdapter(DanceActivity.this,arrayList);
        recyclerView.setAdapter(adapter);
//        int i = adapter.getItemCount();
        callApi(link);
    }

    private void callApi(String link) {
        //Toast.makeText(this,link,Toast.LENGTH_SHORT).show();
        Log.d(TAG, "callApi: "+ link);
        StringRequest stringRequest =new StringRequest(Request.Method.GET,link, response -> {

            Log.d(TAG, "callApi: "+ response);
//            DanceModelTest modelTest = new Gson().fromJson(response,DanceModelTest.class);
//            if (!modelTest.dance.isEmpty()){
//                Toast.makeText(this,Integer.toString(modelTest.dance.size()),Toast.LENGTH_SHORT).show();
//            }
            extract(response.toString());// run app
        },error -> {
            Toast.makeText(this,error.toString(),Toast.LENGTH_SHORT).show();
            Log.d("callApi:",error.toString());
        });
        requestQueue.add(stringRequest);
    }

    private void extract(String response) {
        try {
            JSONObject jsonObject = new JSONObject(String.valueOf(response));
            if (jsonObject.has("dance")){
                JSONArray movies = jsonObject.getJSONArray("dance");
                for (int i=0; i<movies.length(); i++){
                    JSONObject childObj = movies.getJSONObject(i);
                    if (childObj.has("style")){
                        String title = childObj.getString("style");
                String web = childObj.getString("link");
                        DanceModel model = new DanceModel(title,web);
                        arrayList.add(model);
                        adapter.notifyDataSetChanged();
                    }

                }
            }
            Toast.makeText(this,Integer.toString(arrayList.size()),Toast.LENGTH_SHORT).show();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
            Toast.makeText(this,jsonException.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}