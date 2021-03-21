package com.example.health.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.health.R;

public class MyPageFragment extends Fragment {
    public MyPageFragment(){}

    public static MyPageFragment newInstance() {
        MyPageFragment myPageFragment = new MyPageFragment();
        Bundle bundle = new Bundle();
        return myPageFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);
        return view;
    }
}
