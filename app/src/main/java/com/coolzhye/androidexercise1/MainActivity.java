package com.coolzhye.androidexercise1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity {

    public static final String FRAGMENT_STORAGE_TAG = "com.coolzhye.androidexercise1.StorageFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT) {
            SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.pager);
            viewPager.setAdapter(swipeAdapter);
        }
        else {
            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameStorage, new StorageFragment(), FRAGMENT_STORAGE_TAG);
            fragmentTransaction.commit();
        }
    }
}
