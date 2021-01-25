package com.example.workoutforwomen.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutforwomen.Model.ProgressItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;
import java.util.List;

public class ProgressItemAdapter extends RecyclerView.Adapter<ProgressItemAdapter.ViewHolder> {
    Context context;
    ArrayList<ProgressItem> list;
    int widthSize;

    public int getWidthSize() {
        return widthSize;
    }

    public ProgressItemAdapter(Context context, ArrayList<ProgressItem> list, int widthSize) {
        this.context = context;
        this.list = list;
        this.widthSize = widthSize;
    }

    public void setWidthSize(int widthSize) {
        this.widthSize = widthSize;
    }

    public ProgressItemAdapter(Context context, ArrayList<ProgressItem> list) {
        this.context = context;
        this.list = list;
        this.widthSize=0;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProgressItemAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.progress_small_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-ExtraLight.ttf");
        holder.textView.setText(list.get(position).getName());
RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.progressBar.getLayoutParams();
// Changes the height and width to the specified *pixels*
            holder.textView.setTypeface(font2);
        params.height= (int) (list.get(position).getValue()*(context.getResources().getDimension(R.dimen.full_progress))/100);
        if(widthSize==1) {
            params.width= (int) context.getResources().getDimension(R.dimen.big_progress);
           RecyclerView.LayoutParams params1 = (RecyclerView.LayoutParams) holder.container.getLayoutParams();
            params1.rightMargin= (int) (context.getResources().getDimension(R.dimen.default_margin)*4);
            holder.container.setLayoutParams(params1);
        }
        holder.progressBar.setLayoutParams(params);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout progressBar;
        TextView textView;
        RelativeLayout container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar=itemView.findViewById(R.id.progress_line);
            textView=itemView.findViewById(R.id.progress_name);
            container=itemView.findViewById(R.id.progress_container);
        }
    }
}
