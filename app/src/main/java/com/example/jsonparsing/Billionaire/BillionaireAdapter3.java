package com.example.jsonparsing.Billionaire;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonparsing.R;

import java.util.ArrayList;

public class BillionaireAdapter3 extends RecyclerView.Adapter<BillionaireAdapter3.MyViewHolder>{
    Context context;
    ArrayList<BillionaireModal3> arrayList;

    public BillionaireAdapter3(Context context, ArrayList<BillionaireModal3> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.billionaire_item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BillionaireModal3 model =arrayList.get(position);
        holder.t1.setText(model.getBulk());
        holder.t6.setText(model.getName());
        holder.t7.setText(model.getIndustries());
        holder.t8.setText(model.getWorth());
        holder.t9.setText("Rank-"+model.getRank());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BillionaireViewActivity2.class);
                intent.putExtra("bulk", model.getBulk());
                intent.putExtra("name", model.getName());
                intent.putExtra("indus", model.getIndustries());
                intent.putExtra("worth", model.getWorth());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView t1,t6,t7,t8,t9;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);t1.setVisibility(View.GONE);
            t6=itemView.findViewById(R.id.tt2);
            t7=itemView.findViewById(R.id.textView);
            t8=itemView.findViewById(R.id.textView2);
            t9=itemView.findViewById(R.id.tt);
            cardView = itemView.findViewById(R.id.cd);
        }
    }
}
