package com.example.workoutforwomen.Model;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.workoutforwomen.Fragment.ChallengesFragment;
import com.example.workoutforwomen.Fragment.DiscoverFragment;
import com.example.workoutforwomen.Fragment.ExcercisesFragment;
import com.example.workoutforwomen.Fragment.PlansFragment;

public class CustomFragmentPager2 extends FragmentPagerAdapter {
    public CustomFragmentPager2(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                // Your current main fragment showing how to send arguments to fragment

                return new ExcercisesFragment();
            case 1:
                // Calling a Fragment without sending arguments
                return new ChallengesFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
