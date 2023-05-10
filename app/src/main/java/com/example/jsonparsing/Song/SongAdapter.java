package com.example.jsonparsing.Song;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jsonparsing.R;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder>{
    Context context;
    ArrayList<songModel> arrayList;

    public SongAdapter(Context context, ArrayList<songModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.song_item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MediaPlayer player = new MediaPlayer();
    songModel model =arrayList.get(position);
    holder.textView.setText(model.getTitle());
    holder.textView3.setText(model.getUrl());
        Glide.with(context).load(model.getImage()).into(holder.imageView1);
       holder.imageView2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               try {
                   Uri uri = Uri.parse(model.getUrl());
                   player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                   player.setDataSource(context, uri);
                   player.prepare();
                   player.start();
               } catch(Exception e) {
                   System.out.println(e.toString());
               }
           }
       });
       holder.imageView3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
           player.stop();
           }
       });
       holder.textView2.setText(""+(position+1));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView2,textView3;
        ImageView imageView1,imageView2,imageView3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.tt);
            textView3=itemView.findViewById(R.id.textViews);textView3.setVisibility(View.GONE);
            imageView1=itemView.findViewById(R.id.img);
            imageView2=itemView.findViewById(R.id.imageView4);
            imageView3=itemView.findViewById(R.id.imageView5);

        }
    }
}
