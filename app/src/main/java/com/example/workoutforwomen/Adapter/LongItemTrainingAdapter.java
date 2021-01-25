package com.example.workoutforwomen.Adapter;

import android.content.Context;
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

import com.example.workoutforwomen.DataBase.DataManager;
import com.example.workoutforwomen.Model.TrainingItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class LongItemTrainingAdapter extends RecyclerView.Adapter<LongItemTrainingAdapter.ViewHolder> {
    ArrayList<TrainingItem> list;
    Context context;

    public LongItemTrainingAdapter(ArrayList<TrainingItem> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public LongItemTrainingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LongItemTrainingAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.exercise_long_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LongItemTrainingAdapter.ViewHolder holder, int position) {

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
        Log.d("image",(list.get(position).getImage()));
        int resID = context.getResources().getIdentifier(list.get(position).getImage(), "drawable",  context.getPackageName());
        holder.longImg.setImageResource(resID);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTime;
        RelativeLayout container;
        ImageView bookMark,longImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.long_training_name);
            tvTime=itemView.findViewById(R.id.long_training_time);
            container=itemView.findViewById(R.id.long_container);
            bookMark=itemView.findViewById(R.id.long_exercise_button);
            longImg=itemView.findViewById(R.id.item_long_image);
        }
    }
}
