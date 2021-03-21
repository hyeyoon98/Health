package com.example.health.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.health.Fragment.CalendarFragment;
import com.example.health.Fragment.ExerciseRankFragment;
import com.example.health.Fragment.ExerciseReportFragment;
import com.example.health.Fragment.MyPageFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    public static int PAGE_POSITION = 4;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return CalendarFragment.newInstance();
            case 1:
                return ExerciseReportFragment.newInstance();
            case 2:
                return ExerciseRankFragment.newInstance();
            case 3:
                return MyPageFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
