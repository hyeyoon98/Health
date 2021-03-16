package com.example.health;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.health.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setOnClick(this);
        binding.noneLogin.setPaintFlags(binding.noneLogin.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        //binding.noneLogin.setText(Html.fromHtml(getResources().getString(R.string.tv_none_login)));
        //binding.noneLogin.setText(R.string.tv_none_login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kakao_login:
                break;

            case R.id.facebook_login:
                break;

            case R.id.none_login:
                break;
        }

    }
}
