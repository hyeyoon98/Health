package com.example.health;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.health.databinding.ActivityNoneMemberBinding;


public class NoneMemberActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    ActivityNoneMemberBinding binding;
    public final String DATA_STORE = "DATA_STORE";

    String nickname = "nickname";
    String sex = "sex";
    String goal = "goal";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_none_member);
        binding.setTitle("간단한 정보입력");
        binding.insertSex.setOnItemSelectedListener(this);
        binding.startButton.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.label_array,R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        binding.insertSex.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.start_button) {
            if (binding.insertId.getText().toString().trim().length() == 0 || binding.insertGoal.getText().toString().trim().length() ==0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NoneMemberActivity.this);
                showAlert("빈칸을 모두 입력해주시길 바랍니다.");
            } else if (binding.insertId.getText().toString().trim().length() <= 2) {
                showAlert("닉네임을 두 글자 이상으로 정해주시길 바랍니다.");
            } else if (binding.insertGoal.getText().toString().trim().length() <= 5) {
                showAlert("목표를 다섯 글자 이상으로 정해주시길 바랍니다.");
            } else {
                setPreference(nickname,binding.insertId.getText().toString());
                setPreference(goal,binding.insertGoal.getText().toString());
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        setPreference(sex, parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void setPreference(String key, String value){
        SharedPreferences pref = getSharedPreferences(DATA_STORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    //화면 터치 시 키보드 내려감
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View focusView = getCurrentFocus();
        if (focusView != null) {
            Rect rect = new Rect();
            focusView.getGlobalVisibleRect(rect);
            int x = (int) ev.getX(), y = (int) ev.getY();
            if (!rect.contains(x, y)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null)
                    imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
                focusView.clearFocus();
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(NoneMemberActivity.this);
        builder.setTitle("알림")
                .setMessage(message)
                .setPositiveButton("확인", null)
                .create()
                .show();
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
