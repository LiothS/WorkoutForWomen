package com.example.workoutforwomen.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.workoutforwomen.Adapter.DailyInfoAdapter;
import com.example.workoutforwomen.Adapter.DailyInfoDetailAdapter;
import com.example.workoutforwomen.Adapter.ProgressItemAdapter;
import com.example.workoutforwomen.Model.ProgressItem;
import com.example.workoutforwomen.R;

import java.util.ArrayList;

public class DailyFragment extends Fragment {
    public DailyFragment() {
    }
    RecyclerView workoutRv;
    ViewPager vpInfo;
    TextView title,tv1,weekly,tv3,tv4;
    DailyInfoDetailAdapter infoAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily, container, false);

        title=view.findViewById(R.id.daily_title);
        weekly=view.findViewById(R.id.weekly);
        tv1=view.findViewById(R.id.tv1);
        vpInfo=view.findViewById(R.id.daily_view_pager);
        workoutRv=view.findViewById(R.id.time_to_workout_rv);
        tv3=view.findViewById(R.id.tv3);
        tv4=view.findViewById(R.id.tv4);
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface font2 = Typeface.createFromAsset(getContext().getAssets(), "fonts/Poppins-ExtraLight.ttf");
        title.setTypeface(font);
        weekly.setTypeface(font);
        tv1.setTypeface(font);
        tv3.setTypeface(font);
        tv4.setTypeface(font2);

        infoAdapter=new DailyInfoDetailAdapter(getContext());
        vpInfo.setAdapter(infoAdapter);

       vpInfo.setPageMargin(50);
       vpInfo.setCurrentItem(2);
       vpInfo.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {

                    int curr = vpInfo.getCurrentItem();
                    //adapter.showMessage(curr-1);
                    int lastReal = vpInfo.getAdapter().getCount() - 2;
                    if (curr == 0) {
                       vpInfo.setCurrentItem(lastReal, false);
                    } else if (curr > lastReal) {
                        vpInfo.setCurrentItem(1, false);
                    }
                }

            }
        });
        // Time to workout

        ArrayList<ProgressItem> list;
        list=new ArrayList<>();
        list.add(new ProgressItem(50,"A"));
        list.add(new ProgressItem(100,"B"));
        list.add(new ProgressItem(60,"C"));
        list.add(new ProgressItem(20,"D"));
        list.add(new ProgressItem(90,"E"));
        list.add(new ProgressItem(75,"F"));
        list.add(new ProgressItem(10,"G"));
        list.add(new ProgressItem(50,"A"));
        list.add(new ProgressItem(100,"B"));
        list.add(new ProgressItem(60,"C"));
        list.add(new ProgressItem(20,"D"));
        list.add(new ProgressItem(90,"E"));
        list.add(new ProgressItem(75,"F"));
        list.add(new ProgressItem(10,"G"));
        ProgressItemAdapter adapter=new ProgressItemAdapter(getContext(),list,1);
        //adapter.setWidthSize(1);
        workoutRv.setAdapter(adapter);
        workoutRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        return view;
    }
}
