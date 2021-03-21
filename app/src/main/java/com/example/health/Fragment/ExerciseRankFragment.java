package com.example.health.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.health.R;

public class ExerciseRankFragment extends Fragment {

    public ExerciseRankFragment(){}

    public static ExerciseRankFragment newInstance() {
        ExerciseRankFragment exerciseRankFragment = new ExerciseRankFragment();
        Bundle bundle = new Bundle();
        return exerciseRankFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_report, container, false);
        return view;
    }
}
