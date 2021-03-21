package com.example.health;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.health.databinding.ActivityNoneMemberBinding;


public class NoneMemberActivity extends AppCompatActivity {

    ActivityNoneMemberBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_none_member);
        binding.setTitle("간단한 정보입력");
    }
}
