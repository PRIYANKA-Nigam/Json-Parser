package com.example.jsonparsing.Billionaire;

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

public class BillionaireActivity2 extends AppCompatActivity {
    private static final String TAG = "bill";
    RequestQueue requestQueue;
    ArrayList<BillionaireModel2> arrayList;
    RecyclerView recyclerView;
    BillionaireAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billionaire2);
        String link=getIntent().getStringExtra("url");
        seeView(link);
    }

    private void seeView(String link) {
        requestQueue = Volley.newRequestQueue(this);
        recyclerView= findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<>();
        adapter=new BillionaireAdapter2(this,arrayList);
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
            JSONArray movies = jsonObject.getJSONArray("billionaire");
            for (int i=0; i<movies.length(); i++){
                JSONObject childObj = movies.getJSONObject(i);
                String name = childObj.getString("personName");
                String worth = childObj.getString("finalWorth");
                String industry =childObj.getString("category");
                String age =childObj.getString("age");
                String country = childObj.getString("country");
                String state = childObj.getString("state");
                String city = childObj.getString("city");
                String company=childObj.getString("source");
                String title=childObj.getString("title");
                String bio=childObj.getString("bio");

                String bulk=country+"|"+state+"|"+city+"|"+company+"|"+bio+"|"+title+"|"+age;

                BillionaireModel2 model = new BillionaireModel2(name,worth,bulk,industry);
                arrayList.add(model);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }
}