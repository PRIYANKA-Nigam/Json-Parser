package com.example.jsonparsing.BollywoodQuiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonparsing.R;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.MyViewHolder>{
    Context context;
    ArrayList<Question> arrayList;
  static  int c=0,w=0;
    public QuizAdapter(Context context, ArrayList<Question> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.quiz_item_row,parent,false);
        LayoutInflater inflater=LayoutInflater.from(context);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     Question model=arrayList.get(position);
     holder.textView.setText(model.getQuestion());
     holder.b1.setText(model.getAnswer1());
     holder.b2.setText(model.getAnswer2());
     holder.b3.setText(model.getAnswer3());
     holder.b4.setText(model.getAnswer4());
     holder.textView2.setText(""+(position+1));
     holder.b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if(arrayList.get(position).getCorrect().equals(arrayList.get(position).getAnswer1())) {
                 c++;
                 Toast t=Toast.makeText(view.getContext(), Html.fromHtml("<big><h1><font color='#90EE90' ><b>Correct</b></font></h1></big>"), Toast.LENGTH_LONG);
                  t.show(); //given custom layout using Html.fromHtml()[android11 feature]
             }
             else {
                 w++;
                 Toast t=Toast.makeText(view.getContext(), Html.fromHtml("<h1><font color='#FF0000' ><b><u>wrong</u>!!! <br><br>  " +
                     "<big>Correct is -" +arrayList.get(position).getCorrect()+"</big></b></font></h1>"), Toast.LENGTH_LONG);
                 t.setGravity(Gravity.TOP, 0, 0);
                 t.show();
             }

         }
     });
        holder.b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayList.get(position).getCorrect().equals(arrayList.get(position).getAnswer2())) {
                    c++;
                    Toast t=Toast.makeText(view.getContext(), Html.fromHtml("<big><h1><font color='#90EE90' ><b>Correct</b></font></h1></big>"), Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    w++;
                    Toast t=Toast.makeText(view.getContext(), Html.fromHtml("<h1><font color='#FF0000' ><b><u>wrong</u>!!! <br><br>  " +
                            "<big>Correct is -" +arrayList.get(position).getCorrect()+"</big></b></font></h1>"), Toast.LENGTH_LONG);
                    t.setGravity(Gravity.TOP, 0, 0);
                    t.show();
                }

            }
        });
        holder.b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayList.get(position).getCorrect().equals(arrayList.get(position).getAnswer3())) {
                    c++;
                    Toast t=Toast.makeText(view.getContext(), Html.fromHtml("<big><h1><font color='#90EE90' ><b>Correct</b></font></h1></big>"), Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    w++;
                    Toast t=Toast.makeText(view.getContext(), Html.fromHtml("<h1><font color='#FF0000' ><b><u>wrong</u>!!! <br><br>  " +
                            "<big>Correct is -" +arrayList.get(position).getCorrect()+"</big></b></font></h1>"), Toast.LENGTH_LONG);
                    t.setGravity(Gravity.TOP, 0, 0);
                    t.show();
                }

            }
        });
        holder.b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayList.get(position).getCorrect().equals(arrayList.get(position).getAnswer4())) {
                    c++;
                    Toast t=Toast.makeText(view.getContext(), Html.fromHtml("<big><h1><font color='#90EE90' ><b>Correct</b></font></h1></big>"), Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    w++;
                    Toast t=Toast.makeText(view.getContext(), Html.fromHtml("<h1><font color='#FF0000' ><b><u>wrong</u>!!! <br><br>  " +
                            "<big>Correct is -" +arrayList.get(position).getCorrect()+"</big></b></font></h1>"), Toast.LENGTH_LONG);
                    t.setGravity(Gravity.TOP, 0, 0);
                    t.show();
                }

            }
        });
        if(position==arrayList.size()-1){
            Intent intent=new Intent(context,QuizActivity.class);
            intent.putExtra("correct",String.valueOf(c));
            intent.putExtra("wrong",String.valueOf(w));
            context.startActivity(intent);
        }
    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView2,textView3;
        Button b1,b2,b3,b4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           textView=itemView.findViewById(R.id.textView39);
            textView2=itemView.findViewById(R.id.textView40);
//            textView3=itemView.findViewById(R.id.textView41);
            b1=itemView.findViewById(R.id.button);
            b2=itemView.findViewById(R.id.button2);
            b3=itemView.findViewById(R.id.button3);
            b4=itemView.findViewById(R.id.button4);

        }
    }
}
