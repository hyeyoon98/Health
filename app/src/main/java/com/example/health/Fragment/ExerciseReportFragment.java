package com.example.health.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.health.R;

public class ExerciseReportFragment extends Fragment {

    public ExerciseReportFragment() {}

    public static ExerciseReportFragment newInstance() {
        ExerciseReportFragment exerciseReportFragment = new ExerciseReportFragment();
        Bundle bundle = new Bundle();
        return exerciseReportFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_report, container, false);
        return view;
    }
}
