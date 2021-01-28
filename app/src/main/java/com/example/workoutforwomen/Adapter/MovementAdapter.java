package com.example.workoutforwomen.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.workoutforwomen.Model.MovementItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class MovementAdapter extends RecyclerView.Adapter<MovementAdapter.ViewHolder> {
    Context context;
    ArrayList<MovementItem> list;

    public MovementAdapter(Context context, ArrayList<MovementItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MovementAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovementAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.movement_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovementAdapter.ViewHolder holder, int position) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-ExtraLight.ttf");
        holder.time.setTypeface(font2);
        holder.name.setTypeface(font);
        Glide.with(context).asGif().load("file:///android_asset/exercise_img/"+list.get(position).getGif()).into(holder.img);
        holder.name.setText(list.get(position).getName());
        int time=list.get(position).getDuration();
        if(time<60){
            if(time>=10) holder.time.setText("00:"+time);
            else holder.time.setText("00:0"+time);
        }
        else {
           String value="0"+time/60+":";
           int sub=time-(time/60)*60;
           if(sub==0) holder.time.setText(value+"00");
           else if (sub>=10) holder.time.setText(value+sub);
           else holder.time.setText("0"+sub);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name,time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.movement_item_img);
            name=itemView.findViewById(R.id.move_item_name);
            time=itemView.findViewById(R.id.move_item_time);
        }
    }
}
