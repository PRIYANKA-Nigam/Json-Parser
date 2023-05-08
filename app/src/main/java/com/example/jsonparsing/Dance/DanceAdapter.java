package com.example.jsonparsing.Dance;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonparsing.R;

import java.util.ArrayList;

public class DanceAdapter extends RecyclerView.Adapter<DanceAdapter.MyViewHolder>{
    Context context;
    ArrayList<DanceModel> arrayList;

    public DanceAdapter(Context context, ArrayList<DanceModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dance_item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DanceModel model= arrayList.get(position);
        final String[] s = new String[1];
        holder.webView.loadUrl(model.getWeb());
        holder.webView.setWebViewClient(new WebViewClient());
        holder.webView.setWebChromeClient(new WebChromeClient());
        holder.webView.getSettings().setJavaScriptEnabled(true);
        holder.webView. setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                super.onPageStarted(view, url, favicon);
                s[0] =view.getUrl();
                Log.e("URL", url);
            }
        });
        holder.t1.setText(model.getTitle());
        holder.t2.setText(model.getDesc());
        holder.t3.setText(""+(position+1));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DanceViewActivity.class);
                intent.putExtra("link", s[0]);
                intent.putExtra("title", model.getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        WebView webView;
        TextView t1,t2,t3;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            webView =itemView.findViewById(R.id.visible);
            t1=itemView.findViewById(R.id.textView);
            t2=itemView.findViewById(R.id.textView2);
            t3=itemView.findViewById(R.id.tt);
            cardView = itemView.findViewById(R.id.cd);
        }
    }
}
