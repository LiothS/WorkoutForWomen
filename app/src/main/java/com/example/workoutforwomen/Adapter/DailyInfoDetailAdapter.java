package com.example.workoutforwomen.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.workoutforwomen.Model.ChallengeItem;
import com.example.workoutforwomen.Model.ProgressItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;
import java.util.List;

public class DailyInfoDetailAdapter extends PagerAdapter {

    Context context;
    private LayoutInflater layoutInflater;
    TextView tvLevel, tvName, tvLetsGo, tvMessage;
    public DailyInfoDetailAdapter( Context context) {

        this.context = context;

    }
    public TextView textViews[];

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view=null;
        if(position%2==0){
            view = layoutInflater.inflate(R.layout.drink_water_item, container, false);
            TextView tv1,tv2,tvValue,tvBtn;
            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
            Typeface font2 = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-ExtraLight.ttf");
            tv1=view.findViewById(R.id.tv1);
            tvValue=view.findViewById(R.id.drinking_time);
            tv2=view.findViewById(R.id.tv2);
            tvBtn=view.findViewById(R.id.star_drink_water_btn);
            tv1.setTypeface(font);
            tv2.setTypeface(font2);
            tvBtn.setTypeface(font);
            tvValue.setTypeface(font);
            tvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Start drinking water", Toast.LENGTH_SHORT).show();
                }
            });
        }

        else{
            RecyclerView rv;
            TextView tv1,tv2,tvStep,tvDay,tvBtn;
            view = layoutInflater.inflate(R.layout.step_tracking_item, container, false);
            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
            Typeface font2 = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-ExtraLight.ttf");
            rv=view.findViewById(R.id.step_rv);
            tv1=view.findViewById(R.id.tv1);
            tv2=view.findViewById(R.id.tv2);
            tvStep=view.findViewById(R.id.tv_step);
            tvDay=view.findViewById(R.id.tv_per_day);
            tvBtn=view.findViewById(R.id.start_step_btn);
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
            tvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Start walking", Toast.LENGTH_SHORT).show();
                }
            });

            ProgressItemAdapter adapter=new ProgressItemAdapter(context,list);
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        }
        container.addView(view, 0);
        return view;
    }
    public  void showMessage(int position){

        tvMessage.setVisibility(View.VISIBLE);
    }
 
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
