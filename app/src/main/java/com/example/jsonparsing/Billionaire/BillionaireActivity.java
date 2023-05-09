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

public class BillionaireActivity extends AppCompatActivity {
    private static final String TAG = "billionaire";
    RequestQueue requestQueue;
    ArrayList<BillionaireModel> arrayList;
    RecyclerView recyclerView;
    BillionaireAdapter adapter;
   public static String types="1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billionaire);
        String link=getIntent().getStringExtra("url");
//      type= getIntent().getStringExtra("type");
        seeView(link);
    }

    private void seeView(String link) {
        requestQueue = Volley.newRequestQueue(this);
        recyclerView= findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<>();
        adapter=new BillionaireAdapter(this,arrayList);
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
            JSONArray movies = jsonObject.getJSONArray("billionaires");
            for (int i=0; i<movies.length(); i++){
                JSONObject childObj = movies.getJSONObject(i);
                String name = childObj.getString("uri");
                String worth = childObj.getString("finalWorth");
//                String[] sw=worth.split(".");
//                String net=sw[0].substring(0,sw.length-1);
//                String netWorth=net+"0 Million";

                JSONArray in=childObj.getJSONArray("industries");
                String industry =in.getString(0);
                String country = childObj.getString("countryOfCitizenship");

                    String company=childObj.getString("source");
                String bio="";

                JSONArray b =childObj.getJSONArray("bios");
                for(int j=0;j<b.length();j++){
                   bio+=b.getString(j)+".";
                }
                String bulk=country+"|"+company+"|"+bio;

                BillionaireModel model = new BillionaireModel(name,worth,bulk,industry);
                arrayList.add(model);
            }
            adapter.notifyDataSetChanged();
        } catch (Exception jsonException) {
            jsonException.printStackTrace();
        }
    }
}