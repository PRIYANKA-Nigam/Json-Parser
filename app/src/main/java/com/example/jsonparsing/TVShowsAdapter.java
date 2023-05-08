package com.example.jsonparsing;

import android.content.Context;
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
import com.example.jsonparsing.Youtube.YoutubeAdapter;

import java.util.ArrayList;

public class TVShowsAdapter extends RecyclerView.Adapter<TVShowsAdapter.MyViewHolder>{
    Context context;
    ArrayList<TVShowsModel> models;

    public TVShowsAdapter(Context context, ArrayList<TVShowsModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.tvshows_item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TVShowsModel model=models.get(position);
    holder.t1.setText(model.getLanguage());
    holder.t2.setText(model.getGenres());
    holder.t3.setText(model.getRating());
    holder.t4.setText(model.getCountry());
    holder.t5.setText(model.getSummary());
    holder.t6.setText(model.getTitle());
    holder.t7.setText(""+(position+1));
        Glide.with(context).load(model.getImage()).into(holder.imageView);
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
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        WebView webView;
        TextView t1,t2,t3,t4,t5,t6,t7;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.imageView);
            t1=itemView.findViewById(R.id.t1);t1.setVisibility(View.GONE);
            t2=itemView.findViewById(R.id.t2);t2.setVisibility(View.GONE);
            t3=itemView.findViewById(R.id.t3);t3.setVisibility(View.GONE);
            t4=itemView.findViewById(R.id.t4);t4.setVisibility(View.GONE);
            t5=itemView.findViewById(R.id.t5);t5.setVisibility(View.GONE);
            webView=itemView.findViewById(R.id.visible);webView.setVisibility(View.GONE);
            t6=itemView.findViewById(R.id.textView);
            t7=itemView.findViewById(R.id.tt);
            cardView = itemView.findViewById(R.id.cd);
        }
    }
}
