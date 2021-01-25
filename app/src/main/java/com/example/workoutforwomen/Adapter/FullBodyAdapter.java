package com.example.workoutforwomen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutforwomen.Activity.SavedExerciseActivity;
import com.example.workoutforwomen.DataBase.DataManager;
import com.example.workoutforwomen.Model.TrainingItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class FullBodyAdapter extends RecyclerView.Adapter<FullBodyAdapter.ViewHolder> {
    ArrayList<TrainingItem> list;
    Context context;

    public FullBodyAdapter(ArrayList<TrainingItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FullBodyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FullBodyAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.full_body_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FullBodyAdapter.ViewHolder holder, int position) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-ExtraLight.ttf");
        holder.tvName.setText(list.get(position).getName());
        holder.tvTime.setText(list.get(position).getLevel()+" - "+list.get(position).getDuration()+"min");
        holder.tvName.setTypeface(font);
        holder.tvTime.setTypeface(font2);
        switch (list.get(position).getIsSaved()){
            case 0:   holder.bookMark.setImageResource(R.drawable.ic_bookmark_outline);break;
            case 1: holder.bookMark.setImageResource(R.drawable.ic_bookmark_inline_white);break;


        }
        Log.d("issaved",list.get(position).getIsSaved()+"");
        int resID = context.getResources().getIdentifier(list.get(position).getImage(), "drawable",  context.getPackageName());
      holder.container.setBackgroundResource(resID);
        holder.bookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).getIsSaved()==0){
                    DataManager dataManager=DataManager.getInstance(context);
                    dataManager.setSavedExercise(list.get(position).getId(),1);
                    holder.bookMark.setImageResource(R.drawable.ic_bookmark_inline_white);
                    list.get(position).setIsSaved(1);
                }
                else{
                    DataManager dataManager=DataManager.getInstance(context);
                    dataManager.setSavedExercise(list.get(position).getId(),0);
                    holder.bookMark.setImageResource(R.drawable.ic_bookmark_outline);
                    list.get(position).setIsSaved(0);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTime;
        RelativeLayout container;
        ImageView bookMark;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.fullbody_name);
            tvTime=itemView.findViewById(R.id.fullbody_time);
            container=itemView.findViewById(R.id.full_body_container);
            bookMark=itemView.findViewById(R.id.exercise_button);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, SavedExerciseActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
