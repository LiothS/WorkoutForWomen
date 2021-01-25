package com.example.workoutforwomen.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.workoutforwomen.Adapter.BeginerPlanAdapter;
import com.example.workoutforwomen.Adapter.ChallengeAdapter;
import com.example.workoutforwomen.Adapter.ChallengeDetailAdapter;
import com.example.workoutforwomen.Adapter.DayAdapter;
import com.example.workoutforwomen.Model.BeginerPlanItem;
import com.example.workoutforwomen.Model.ChallengeItem;
import com.example.workoutforwomen.Model.DayItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class ChallengesFragment extends Fragment {
    public ChallengesFragment() {
    }
    ArrayList <ChallengeItem> challengeList;
    ChallengeDetailAdapter adapter;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmet_challenges, container, false);
        viewPager=view.findViewById(R.id.challenge_view_pager);

       viewPager.setPageMargin(50);

        challengeList=new ArrayList<>();
        challengeList.add(new ChallengeItem("First Item","Level 1","1 One solution is to use a media query at a certain screen size."));
        challengeList.add(new ChallengeItem("Second Item","Level 2","Second item message"));
        challengeList.add(new ChallengeItem("Third Item","Level 3","Third item message"));
        challengeList.add(new ChallengeItem("Last Item","Level 4","Last item message"));
        ArrayList<ChallengeItem> list=new ArrayList<>();
        list.add(challengeList.get(challengeList.size()-1));
        for(int i=0;i<challengeList.size();i++) list.add(challengeList.get(i));
        list.add(challengeList.get(0));
        adapter=new ChallengeDetailAdapter(list,getContext());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(2);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                adapter.textViews[position].setVisibility(View.VISIBLE);
                try{
                    adapter.textViews[position-1].setVisibility(View.GONE);
                    adapter.textViews[position+1].setVisibility(View.GONE);
                }
                catch (Exception e){

                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {

                    int curr = viewPager.getCurrentItem();
                    //adapter.showMessage(curr-1);
                    int lastReal = viewPager.getAdapter().getCount() - 2;
                    if (curr == 0) {
                        viewPager.setCurrentItem(lastReal, false);
                    } else if (curr > lastReal) {
                        viewPager.setCurrentItem(1, false);
                    }
                }

            }
        });
        return view;
    }
}
