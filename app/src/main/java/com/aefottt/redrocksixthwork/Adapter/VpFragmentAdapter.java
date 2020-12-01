package com.aefottt.redrocksixthwork.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VpFragmentAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fmList;
    String[] labels;

    public VpFragmentAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Fragment> fmList, String[] labels) {
        super(fm, behavior);
        this.fmList = fmList;
        this.labels = labels;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fmList.get(position);
    }

    @Override
    public int getCount() {
        return fmList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return labels[position];
    }
}
