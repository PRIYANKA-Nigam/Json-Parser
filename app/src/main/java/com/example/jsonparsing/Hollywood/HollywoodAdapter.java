package com.example.jsonparsing.Hollywood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jsonparsing.R;

import java.util.ArrayList;

public class HollywoodAdapter extends RecyclerView.Adapter<HollywoodAdapter.MyViewHolder>{
    Context context;
    ArrayList<HollywoodModel> arrayList;

    public HollywoodAdapter(Context context, ArrayList<HollywoodModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.hollywood_item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HollywoodModel model=arrayList.get(position);
    holder.t1.setText(model.getYear());
    holder.t2.setText(model.getGenre());
    holder.t3.setText(model.getDirector());
holder.t4.setText(model.getWriter());
holder.t5.setText(model.getActor());
holder.t6.setText(model.getPlot());
holder.t7.setText(model.getLanguage());
holder.t8.setText(model.getCountry());
holder.t9.setText(model.getAwards());
holder.t10.setText(model.getTitle());
        Glide.with(context).load(model.getImage()).into(holder.imageView);
        holder.t11.setText(""+(position+1));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, HollywoodViewActivity.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("title", model.getTitle());
                intent.putExtra("year", model.getYear());
                intent.putExtra("genre", model.getGenre());
                intent.putExtra("director", model.getDirector());
                intent.putExtra("writer", model.getWriter());
                intent.putExtra("actor", model.getActor());
                intent.putExtra("plot", model.getPlot());
                intent.putExtra("language", model.getLanguage());
                intent.putExtra("country", model.getCountry());
                intent.putExtra("awards", model.getAwards());
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
        TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        imageView =itemView.findViewById(R.id.imageView);
            t1=itemView.findViewById(R.id.t1);t1.setVisibility(View.GONE);
            t2=itemView.findViewById(R.id.t2);t2.setVisibility(View.GONE);
            t3=itemView.findViewById(R.id.t3);t3.setVisibility(View.GONE);
            t4=itemView.findViewById(R.id.t4);t4.setVisibility(View.GONE);
            t5=itemView.findViewById(R.id.t5);t5.setVisibility(View.GONE);
            t6=itemView.findViewById(R.id.t6);t6.setVisibility(View.GONE);
            t7=itemView.findViewById(R.id.t7);t7.setVisibility(View.GONE);
            t8=itemView.findViewById(R.id.t8);t8.setVisibility(View.GONE);
            t9=itemView.findViewById(R.id.t9);t9.setVisibility(View.GONE);
            t10=itemView.findViewById(R.id.textView);
            t11=itemView.findViewById(R.id.tt);
            cardView = itemView.findViewById(R.id.cd);
        }
    }
}
