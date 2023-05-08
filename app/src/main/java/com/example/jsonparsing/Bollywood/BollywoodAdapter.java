package com.example.jsonparsing.Bollywood;

import android.content.Context;
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

public class BollywoodAdapter extends RecyclerView.Adapter<BollywoodAdapter.MyViewHolder>{
    Context context;
    ArrayList<BollywoodModel> arrayList;

    public BollywoodAdapter(Context context, ArrayList<BollywoodModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.bollywood_item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BollywoodModel model=arrayList.get(position);
    holder.t1.setText(model.getYear());
    holder.t2.setText(model.getGenre());
    holder.t3.setText(model.getStory());
    holder.t4.setText(model.getActors());
    holder.t5.setText(model.getTitle());
    holder.t6.setText(""+(position+1));
        Glide.with(context).load(model.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView t1,t2,t3,t4,t5,t6;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.imageView);
            t1=itemView.findViewById(R.id.t1);t1.setVisibility(View.GONE);
            t2=itemView.findViewById(R.id.t2);t2.setVisibility(View.GONE);
            t3=itemView.findViewById(R.id.t3);t3.setVisibility(View.GONE);
            t4=itemView.findViewById(R.id.t4);t4.setVisibility(View.GONE);
            t5=itemView.findViewById(R.id.textView);
            t6=itemView.findViewById(R.id.tt);
            cardView = itemView.findViewById(R.id.cd);
        }
    }
}
