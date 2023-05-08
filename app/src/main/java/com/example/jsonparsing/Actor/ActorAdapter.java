package com.example.jsonparsing.Actor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jsonparsing.R;

import java.util.ArrayList;

public class ActorAdapter extends ArrayAdapter<ActorModal> {
    public ActorAdapter(@NonNull Context context, ArrayList<ActorModal> list ) {
        super(context,0,list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ActorModal modal =getItem(position);
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.actor_item_row,parent,false);
        }
        TextView tv1 = convertView.findViewById(R.id.textView2);
        TextView tv2 = convertView.findViewById(R.id.textView3);
        TextView tv3 = convertView.findViewById(R.id.textView4);
        tv1.setText(modal.getName());
        tv2.setText(modal.getAlt());
        tv3.setText(modal.getRating());
        return convertView;
    }
}
