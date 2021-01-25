package com.example.workoutforwomen.Model;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.workoutforwomen.Fragment.ActivitiesFragment;
import com.example.workoutforwomen.Fragment.DailyFragment;
import com.example.workoutforwomen.Fragment.DiscoverFragment;
import com.example.workoutforwomen.Fragment.HomeFragment;
import com.example.workoutforwomen.Fragment.PlansFragment;
import com.example.workoutforwomen.Fragment.SettingFragment;

public class CustomFragmentPager extends FragmentPagerAdapter {
    public CustomFragmentPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                // Your current main fragment showing how to send arguments to fragment

                return new PlansFragment();
            case 1:
                // Calling a Fragment without sending arguments
                return new DiscoverFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
