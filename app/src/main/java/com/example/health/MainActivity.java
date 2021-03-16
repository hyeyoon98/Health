package com.example.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import static com.example.health.FragmentAdapter.PAGE_POSITION;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loadTabName();
        setTabLayout();
        setViewPager();
      //  setCallButton();

    }

    @TargetApi(Build.VERSION_CODES.N)
    private void setTabLayout(){
        tabLayout = findViewById(R.id.tab);

      //  tabNames.stream().forEach(name ->tabLayout.addTab(tabLayout.newTab().setText(name)));

    }

    private void setViewPager() {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), PAGE_POSITION);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}