package com.example.workoutforwomen.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutforwomen.Model.BeginerPlanItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class BeginerPlanAdapter extends RecyclerView.Adapter<BeginerPlanAdapter.ViewHolder> {
    ArrayList<BeginerPlanItem> list;
    Context context;

    public BeginerPlanAdapter(ArrayList<BeginerPlanItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BeginerPlanAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.plan_for_beginer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-ExtraLight.ttf");
        holder.tvPlanName.setText(list.get(position).getPlanName());
        holder.tvPlanTime.setText(list.get(position).getPlanTime());
        holder.tvPlanName.setTypeface(font);
        holder.tvPlanTime.setTypeface(font2);
        if(list.get(position).getPlanName().contains("Abs")){
            holder.relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.testing_color));

        }
        holder.tvLetsGo.setTypeface(font);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlanName, tvPlanTime, tvLetsGo;
        ImageView bookmark;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlanName=itemView.findViewById(R.id.trainning_name);
            tvPlanTime=itemView.findViewById(R.id.trainning_time);
            tvLetsGo=itemView.findViewById(R.id.plan_lets_go);
            bookmark=itemView.findViewById(R.id.plan_button);
            relativeLayout=itemView.findViewById(R.id.plan_container);
        }
    }
}
