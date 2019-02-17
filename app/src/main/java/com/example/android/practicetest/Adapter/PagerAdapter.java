package com.example.android.practicetest.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.android.practicetest.Fragments.Fragment1;
import com.example.android.practicetest.Fragments.Fragment2;
import com.example.android.practicetest.Fragments.Fragment3;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int number;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.number = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return number;
    }
}
