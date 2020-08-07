package com.neversettle.statusdownloader.ui.whatsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.neversettle.statusdownloader.ui.fragment.PictureFragment;
import com.neversettle.statusdownloader.ui.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private static int NUM_ITEMS = 2;
    private final List<String> fragmentNames = new ArrayList<>(Arrays.asList("Images","Videos" ));

    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return PictureFragment.newInstance();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return VideoFragment.newInstance();
            default:
                return null;
        }
    }
    public CharSequence getPageTitle(int position) {
        return fragmentNames.get(position);
    }


    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
