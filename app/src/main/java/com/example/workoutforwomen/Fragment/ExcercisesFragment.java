package com.example.workoutforwomen.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutforwomen.Adapter.BeginerPlanAdapter;
import com.example.workoutforwomen.Adapter.ChallengeAdapter;
import com.example.workoutforwomen.Adapter.DayAdapter;
import com.example.workoutforwomen.Adapter.LongItemTrainingAdapter;
import com.example.workoutforwomen.DataBase.DataManager;
import com.example.workoutforwomen.Model.BeginerPlanItem;
import com.example.workoutforwomen.Model.ChallengeItem;
import com.example.workoutforwomen.Model.DayItem;
import com.example.workoutforwomen.Model.TrainingItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class ExcercisesFragment extends Fragment {
    public ExcercisesFragment() {
    }
    TextView tv1,tv2,totalMin,totalEx,today,yesterday;
    ArrayList<TrainingItem> list1,list2;
    LongItemTrainingAdapter adapter,adapter2;
    RecyclerView rvToday, rvYesterday;
    DataManager dataManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_excercises, container, false);
        tv1=view.findViewById(R.id.tv_total_min);
        tv2=view.findViewById(R.id.tv_total_ex);
        today=view.findViewById(R.id.today);
        yesterday=view.findViewById(R.id.yesterday);
        totalMin=view.findViewById(R.id.total_minute);
        totalEx=view.findViewById(R.id.total_exercise);
        rvToday=view.findViewById(R.id.today_ex);
        rvYesterday=view.findViewById(R.id.yesterday_ex);
        dataManager=DataManager.getInstance(getContext());
        Typeface font1 = Typeface.createFromAsset(getContext().getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(getContext().getAssets(), "fonts/Poppins-ExtraLight.ttf");
        tv1.setTypeface(font2);tv2.setTypeface(font2);
        totalEx.setTypeface(font1);totalMin.setTypeface(font1);
        today.setTypeface(font1);yesterday.setTypeface(font1);
        list1=dataManager.getTrainingItemList(2);

        adapter=new LongItemTrainingAdapter(list1,getContext());
       rvToday.setAdapter(adapter);
       rvToday.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
       rvToday.setNestedScrollingEnabled(false);



        // setup 2

        list2=dataManager.getTrainingItemList(3);
        adapter2=new LongItemTrainingAdapter(list2,getContext());
        rvYesterday.setAdapter(adapter2);

        rvYesterday.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        return view;
    }
}
