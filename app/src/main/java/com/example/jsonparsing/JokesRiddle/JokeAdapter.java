package com.example.jsonparsing.JokesRiddle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonparsing.R;

import java.util.ArrayList;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.MyViewHolder>{
private Context context;
ArrayList<JokesModel> arrayList;

    public JokeAdapter(Context context, ArrayList<JokesModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.joke_riddle_item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    JokesModel model =arrayList.get(position);
    holder.t1.setText(model.getJokes());
    holder.t2.setText(model.getAnswer());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
    TextView t1,t2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.textView);
            t2=itemView.findViewById(R.id.textView2);
        }
    }
}
