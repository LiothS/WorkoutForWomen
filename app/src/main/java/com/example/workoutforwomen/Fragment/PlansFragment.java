package com.example.workoutforwomen.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
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
import com.example.workoutforwomen.Model.BeginerPlanItem;
import com.example.workoutforwomen.Model.ChallengeItem;
import com.example.workoutforwomen.Model.DayItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class PlansFragment extends Fragment {
    public PlansFragment() {
    }
    ArrayList<DayItem> list;
    ArrayList<BeginerPlanItem> planList;
    ArrayList<ChallengeItem> challengeList;
    BeginerPlanAdapter beginerPlanAdapter;
    DayAdapter dayAdapter;
    ChallengeAdapter challengeAdapter;
    RecyclerView rvDay,rvPlan,rvChallenge;
    TextView planText,challengeTest;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plans, container, false);
        rvDay=view.findViewById(R.id.day_recyclerview);
        list=new ArrayList<>();
        for(int i=0;i<30;i++){
            list.add(new DayItem("Tue",""+(i+1),false));
        }
        list.get(2).setActive(true);
        dayAdapter=new DayAdapter(list,getContext());
        rvDay.setAdapter(dayAdapter);
        rvDay.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        //Setup planList

        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Poppins-Bold.ttf");
        planText=view.findViewById(R.id.text_plan);
        planText.setTypeface(font);
        planList=new ArrayList<>();
        planList.add(new BeginerPlanItem("Training Aims","Beginner - 17 mins"));
        planList.add(new BeginerPlanItem("Training Abs","Beginner - 15 mins"));
        beginerPlanAdapter=new BeginerPlanAdapter(planList,getContext());
        rvPlan=view.findViewById(R.id.plan_recyclerview);
        rvPlan.setAdapter(beginerPlanAdapter);
        rvPlan.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));



        //Setup challengeList



        challengeTest=view.findViewById(R.id.text_challenge);
        challengeTest.setTypeface(font);
       challengeList=new ArrayList<>();
        challengeList.add(new ChallengeItem("Hold Breath","Level 1"));
        challengeList.add(new ChallengeItem("Hold Breath","Level 2"));
        challengeList.add(new ChallengeItem("Hold Breath","Level 3"));
        challengeList.add(new ChallengeItem("Hold Breath","Level 4"));
        challengeAdapter=new ChallengeAdapter(challengeList,getContext());
        rvChallenge=view.findViewById(R.id.challenge_recyclerview);
        rvChallenge.setAdapter(challengeAdapter);
        rvChallenge.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        return view;
    }
}
