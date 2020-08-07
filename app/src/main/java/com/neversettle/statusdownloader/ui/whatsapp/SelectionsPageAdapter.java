package com.neversettle.statusdownloader.ui.whatsapp;


import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.neversettle.statusdownloader.R;
import com.neversettle.statusdownloader.ui.fragment.PictureFragment;
import com.neversettle.statusdownloader.ui.fragment.VideoFragment;


import java.util.ArrayList;
import java.util.List;

public class SelectionsPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String>fragmentNames = new ArrayList<>();

    public SelectionsPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        fragments.clear();
        fragments.add(new PictureFragment());
        fragmentNames.add(context.getString(R.string.tab_image));
        fragments.add(new VideoFragment());
        fragmentNames.add(context.getString(R.string.tab_video));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position){
        return fragmentNames.get(position);
    }
}