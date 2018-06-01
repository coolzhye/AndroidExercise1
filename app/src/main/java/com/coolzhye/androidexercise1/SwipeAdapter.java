package com.coolzhye.androidexercise1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SwipeAdapter extends FragmentStatePagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return position == 1 ? new StorageFragment() : new LightFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
