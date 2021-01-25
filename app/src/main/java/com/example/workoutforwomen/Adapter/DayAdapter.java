package com.example.workoutforwomen.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutforwomen.Model.DayItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.ViewHolder> {
    ArrayList<DayItem> list;
    Context context;

    public DayAdapter(ArrayList<DayItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new DayAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.date_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDay.setText(list.get(position).getDayString());
        holder.tvNumber.setText(list.get(position).getDayNumber());
        if(list.get(position).isActive()) {
            holder.activeCircle.setBackground(context.getResources().getDrawable(R.drawable.active_circle_bg));
            holder.container.setBackground(context.getResources().getDrawable(R.drawable.day_card_border_active));
          //  holder.cardView.setBackground(context.getResources().getDrawable(R.drawable.day_card_border_active));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.cardView.setElevation(5);

            }
            holder.tvDay.setTextColor(context.getResources().getColor(R.color.white));
            holder.tvNumber.setTextColor(context.getResources().getColor(R.color.white));
        }
        else{
            holder.activeCircle.setBackground(context.getResources().getDrawable(R.drawable.inactive_circle_bg));
            holder.container.setBackground(context.getResources().getDrawable(R.drawable.day_card_border));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.cardView.setElevation(0);
                holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.white));

            }
            holder.tvDay.setTextColor(context.getResources().getColor(R.color.textColor));
            holder.tvNumber.setTextColor(context.getResources().getColor(R.color.textColor));
        }
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Medium.ttf");
        holder.tvDay.setTypeface(font);
        holder.tvNumber.setTypeface(font);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvDay, tvNumber;
        LinearLayout activeCircle,container;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay=itemView.findViewById(R.id.tv_day);
            tvNumber=itemView.findViewById(R.id.tv_day_number);
            activeCircle=itemView.findViewById(R.id.active_circle);
            container=itemView.findViewById(R.id.contain_day_layout);
            cardView=itemView.findViewById(R.id.day_cardview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i=0;i<list.size();i++)
                    {
                        list.get(i).setActive(false);
                    }
                    list.get(getAdapterPosition()).setActive(true);
                    notifyDataSetChanged();

                }
            });

        }
    }
}
