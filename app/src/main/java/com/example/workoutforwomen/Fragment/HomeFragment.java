package com.example.workoutforwomen.Fragment;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.workoutforwomen.Activity.SavedExerciseActivity;
import com.example.workoutforwomen.Model.CustomFragmentPager;
import com.example.workoutforwomen.NavigateItem.TabItem;
import com.example.workoutforwomen.R;

import static android.content.Context.MODE_PRIVATE;
import static maes.tech.intentanim.CustomIntent.customType;

public class HomeFragment extends Fragment {
    public HomeFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences pref = getContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        boolean reload=pref.getBoolean("reload",false);
      if(reload){
          SharedPreferences.Editor editor=pref.edit();
          editor.putBoolean("reload",false);
          editor.commit();
          FragmentManager fm = getChildFragmentManager();
          CustomFragmentPager adapter=new CustomFragmentPager(fm,1);
          viewPager.setAdapter(adapter);
          viewPager.setCurrentItem(1);
      }else viewPager.setCurrentItem(0);

    }
    ViewPager viewPager;
    LinearLayout swipe_line;
    TabItem tab1,tab2;
    ImageView savedBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView tv2;
         swipe_line=view.findViewById(R.id.swipe_line);
        viewPager=view.findViewById(R.id.view_pager_home);
        savedBtn=view.findViewById(R.id.home_saved_btn);
        savedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), SavedExerciseActivity.class);
                startActivity(intent);
                customType(getContext(),"left-to-right");
            }
        });
        FragmentManager fm = getChildFragmentManager();
        CustomFragmentPager adapter=new CustomFragmentPager(fm,1);
        viewPager.setAdapter(adapter);

        viewPager.setCurrentItem(0);
        tab1= view.findViewById(R.id.tab_item1);
        tab2= view.findViewById(R.id.tab_item2);

        tab1.setTabName("Your Plans");
        tab2.setTabName("Discover");
        tab2.Deactivate();
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) swipe_line.getLayoutParams();
        //params.leftMargin = (int)(getResources().getDimension(R.dimen.default_margin));
       viewPager.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               viewPager.setCurrentItem(viewPager.getCurrentItem());
               return true;
           }

       });
        swipe_line.setLayoutParams(params);

        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tab1.Activate();
                tab2.Deactivate();
                viewPager.setCurrentItem(0);
                SwipeToLeft();
            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tab2.Activate();
                tab1.Deactivate();
                viewPager.setCurrentItem(1);
                SwipeToRight();

            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0) {
                    SwipeToLeft();
                    tab1.Activate();
                    tab2.Deactivate();
                }
                else {
                    SwipeToRight();
                    tab2.Activate();
                    tab1.Deactivate();
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        //SetUp arrayList




        return view;
    }

    private void SwipeToLeft() {
        ValueAnimator animator = ValueAnimator.ofFloat(1f, 0f);
int width=tab2.getWidth();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) swipe_line.getLayoutParams();
                params.width= (int) (tab1.getTextViewWidth()-getResources().getDimension(R.dimen.default_margin)*4);
                params.leftMargin = (int)(width*value);
                if(width*value<=getResources().getDimension(R.dimen.default_margin)*2) {

                    params.leftMargin = (int)(getResources().getDimension(R.dimen.default_margin)*2);

                    swipe_line.setLayoutParams(params);
                    return;
                };
                swipe_line.setLayoutParams(params);
                if(value<=0.0f) {
                    params.width=20;
                    params.leftMargin = (int)(getResources().getDimension(R.dimen.default_margin)*2);

                    swipe_line.setLayoutParams(params);
                }
                //  Toast.makeText(getContext(), ""+measuredTitleWidth, Toast.LENGTH_SHORT).show();
                //tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

            }
        });
        animator.start();
    }

    private void SwipeToRight() {

        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
        int width=tab1.getWidth();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
               RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) swipe_line.getLayoutParams();
                params.leftMargin = (int)(width*value);
                if(params.leftMargin>=getResources().getDimension(R.dimen.default_margin))
                {
                    swipe_line.setLayoutParams(params);
                    params.width=tab2.getTextViewWidth();
                }

                if(value>=1.0f) {
                    params.width= (int) (tab2.getTextViewWidth()-getResources().getDimension(R.dimen.default_margin)*4);
                    params.leftMargin = (int)(tab1.getWidth()+getResources().getDimension(R.dimen.default_margin)*2+
                            getResources().getDimension(R.dimen.tab_break));

                    swipe_line.setLayoutParams(params);
                   }
                //  Toast.makeText(getContext(), ""+measuredTitleWidth, Toast.LENGTH_SHORT).show();
                //tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

            }
        });
        animator.start();
    }


}
