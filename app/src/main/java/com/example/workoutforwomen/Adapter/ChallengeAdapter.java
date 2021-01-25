package com.example.workoutforwomen.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutforwomen.Model.BeginerPlanItem;
import com.example.workoutforwomen.Model.ChallengeItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ViewHolder> {
    ArrayList<ChallengeItem> list;
    Context context;

    public ChallengeAdapter(ArrayList<ChallengeItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ChallengeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChallengeAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.challenge_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeAdapter.ViewHolder holder, int position) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-ExtraLight.ttf");
        holder.tvName.setText(list.get(position).getChallengeName());
        holder.tvLevel.setText(list.get(position).getChallengeLv());
        if(position%2==0){
            holder.container.setBackgroundColor(context.getResources().getColor(R.color.test_red));
            holder.tvQuestionMark.setTextColor(context.getResources().getColor(R.color.test_red));
        }
        else
        {
            holder.container.setBackgroundColor(context.getResources().getColor(R.color.testcolor_blue));
            holder.tvQuestionMark.setTextColor(context.getResources().getColor(R.color.testcolor_blue));
        }
        holder.tvName.setTypeface(font);
        holder.tvLevel.setTypeface(font2);
        holder.tvQuestionMark.setTypeface(font);
        holder.tvLestGo.setTypeface(font);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvLevel, tvQuestionMark, tvLestGo;
        RelativeLayout container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.challenge_name);
            tvLevel=itemView.findViewById(R.id.challenge_lv);
            tvQuestionMark=itemView.findViewById(R.id.question_mark);
            container=itemView.findViewById(R.id.challenge_container);
            tvLestGo=itemView.findViewById(R.id.challenge_lets_go);
        }
    }
}
