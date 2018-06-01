package com.coolzhye.androidexercise1;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT) {
            SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.pager);
            viewPager.setAdapter(swipeAdapter);
        }
    }
}
