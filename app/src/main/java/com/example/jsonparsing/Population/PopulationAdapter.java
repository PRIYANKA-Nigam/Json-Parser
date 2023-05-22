package com.example.jsonparsing.Population;

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

public class PopulationAdapter extends ArrayAdapter<PopulationModel> {

    public PopulationAdapter(@NonNull Context context,  ArrayList<PopulationModel> list) {
        super(context, 0,list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PopulationModel model=getItem(position);
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.population_item_row,parent,false);
        }
        TextView textView=convertView.findViewById(R.id.textView2);
        TextView textView2=convertView.findViewById(R.id.textView3);
        TextView textView3=convertView.findViewById(R.id.tt);
        textView.setText(model.getCountry());
        textView2.setText(model.getPopulation());
        textView3.setText(""+(position+1)+".");
        return convertView;
    }
}
