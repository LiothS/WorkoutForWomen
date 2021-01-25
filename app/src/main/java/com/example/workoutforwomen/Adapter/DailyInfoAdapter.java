package com.example.workoutforwomen.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutforwomen.Model.ProgressItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class DailyInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    public DailyInfoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder;
        switch (viewType){
            case 0:
                View view = inflater.inflate(R.layout.drink_water_item, parent, false);
                viewHolder= new ViewHolder0(view);
                break;
            case 1:
                View view1 = inflater.inflate(R.layout.step_tracking_item, parent, false);
                viewHolder= new ViewHolder1(view1);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }

        return viewHolder;
    }
    @Override
    public int getItemViewType(int position) {
       return position;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case 0:
                ViewHolder0 viewHolder0 = (ViewHolder0)holder;
                break;
            case 1:
                ViewHolder1 viewHolder1 = (ViewHolder1)holder;
                break;

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
    class ViewHolder0 extends RecyclerView.ViewHolder{
        TextView tv1,tv2,tvValue,tvBtn;

        public ViewHolder0(@NonNull View itemView) {
            super(itemView);
            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
            Typeface font2 = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-ExtraLight.ttf");
            tv1=itemView.findViewById(R.id.tv1);
            tvValue=itemView.findViewById(R.id.drinking_time);
            tv2=itemView.findViewById(R.id.tv2);
            tvBtn=itemView.findViewById(R.id.star_drink_water_btn);
            tv1.setTypeface(font);
            tv2.setTypeface(font2);
            tvBtn.setTypeface(font);
            tvValue.setTypeface(font);
        }
    }
    class ViewHolder1 extends RecyclerView.ViewHolder{
    RecyclerView rv;
    TextView tv1,tv2,tvStep,tvDay,tvBtn;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
            Typeface font2 = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-ExtraLight.ttf");
            rv=itemView.findViewById(R.id.step_rv);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            tvStep=itemView.findViewById(R.id.tv_step);
            tvDay=itemView.findViewById(R.id.tv_per_day);
            tvBtn=itemView.findViewById(R.id.start_step_btn);
            tv1.setTypeface(font);
            tv2.setTypeface(font2);
            tvStep.setTypeface(font);
            tvDay.setTypeface(font2);
            tvBtn.setTypeface(font);
            ArrayList<ProgressItem> list;
            list=new ArrayList<>();
            list.add(new ProgressItem(50,"A"));
            list.add(new ProgressItem(100,"B"));
            list.add(new ProgressItem(60,"C"));
            list.add(new ProgressItem(20,"D"));
            list.add(new ProgressItem(90,"E"));
            list.add(new ProgressItem(75,"F"));
            list.add(new ProgressItem(10,"G"));


            ProgressItemAdapter adapter=new ProgressItemAdapter(context,list);
            rv.setAdapter(adapter);
           rv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        }
    }
}
