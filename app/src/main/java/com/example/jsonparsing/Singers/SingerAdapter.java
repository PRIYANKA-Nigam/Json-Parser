package com.example.jsonparsing.Singers;

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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jsonparsing.R;

import java.util.ArrayList;

public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.MyViewHolder>{
Context context;
ArrayList<SingerModal> arrayList;

    public SingerAdapter(Context context, ArrayList<SingerModal> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.singer_item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SingerModal modal=arrayList.get(position);
holder.t1.setText(modal.getName());
holder.t4.setText(modal.getGenres());
holder.t2.setText(modal.getFollowers());
holder.t3.setText(""+(position+1));
Glide.with(context).load(modal.getImage()).into(holder.imageView);
        final String[] s = new String[1];
        holder.webView.loadUrl(modal.getWeb());
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
holder.cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context, SingerViewActivity.class);
        intent.putExtra("link", s[0]);
        intent.putExtra("title", modal.getName());
        context.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
  ImageView imageView;
        TextView t1,t2,t3,t4;
        CardView cardView;
        WebView webView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
         imageView =itemView.findViewById(R.id.img);
            t1=itemView.findViewById(R.id.textView);
            t2=itemView.findViewById(R.id.textView2);
            t3=itemView.findViewById(R.id.tt);
            t4=itemView.findViewById(R.id.textView3);
            cardView = itemView.findViewById(R.id.cd);
            webView=itemView.findViewById(R.id.visible);
            webView.setVisibility(View.GONE);
        }
    }
}
