package com.example.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;

import com.example.health.Fragment.FragmentAdapter;
import com.example.health.databinding.ActivityLoginBinding;
import com.example.health.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import static com.example.health.Fragment.FragmentAdapter.PAGE_POSITION;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> tabNames = new ArrayList<>();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        loadTabName();
        setTabLayout();
        setViewPager();

    }

    @TargetApi(Build.VERSION_CODES.N)
    private void setTabLayout(){
        tabLayout = binding.tab;
        tabNames.stream().forEach(name ->tabLayout.addTab(tabLayout.newTab().setText(name)));
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_calendar);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_chart);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_trophy);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_mypage);

        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#0070C0"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#0070C0"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#0070C0"), PorterDuff.Mode.SRC_IN);
    }

    //탭 이름 설정
    private void loadTabName(){
        tabNames.add("운동일지");
        tabNames.add("운동 리포트");
        tabNames.add("운동 순위");
        tabNames.add("마이페이지");
    }

    private void setViewPager() {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), PAGE_POSITION);
        viewPager = binding.viewPager;
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#0070C0"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}