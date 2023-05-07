package com.example.jsonparsing;

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

import java.util.ArrayList;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.MyViewHolder>{
Context context;
ArrayList<ComicModel> arrayList;

    public ComicAdapter(Context context, ArrayList<ComicModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comic_item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    ComicModel model = arrayList.get(position);
        final String[] s = new String[1];
//        holder.webView.loadUrl(model.getComic());
//        holder.webView.setWebViewClient(new WebViewClient());
//        holder.webView.setWebChromeClient(new WebChromeClient());
//        holder.webView.getSettings().setJavaScriptEnabled(true);
//        holder.webView. setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon){
//                super.onPageStarted(view, url, favicon);
//                s[0] =view.getUrl();
//                Log.e("URL", url);
//            }
//        });
    holder.textView.setText(model.getTitle());
    Glide.with(context).load(model.getImage()).into(holder.imageView);
    holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent =new Intent(context,ComicViewActivity.class);
            intent.putExtra("title",model.getTitle());
//            intent.putExtra("comic",s[0]);
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
TextView textView;
ImageView imageView;
CardView cardView;
//WebView webView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView= itemView.findViewById(R.id.imageView);
            cardView= itemView.findViewById(R.id.cd);
        }
    }
}
