package com.neversettle.statusdownloader.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;


import androidx.annotation.MenuRes;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.neversettle.statusdownloader.R;
import com.neversettle.statusdownloader.ui.main.MainNavigator;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CustomAppBar extends AppBarLayout {


    @BindView(R.id.view_main_toolbar)
    Toolbar mtoolbar;

    @BindView(R.id.main_tabs)
    ListenableTabLayout mTabLayout;


    public CustomAppBar(Context context) {
        super(context);
        init();
    }

    public CustomAppBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_main_toolbar, this, true);
        ButterKnife.bind(this);
        mtoolbar.setNavigationIcon(R.drawable.ic_action_menu);

    }


    public void setOnNavigationClickListener(View.OnClickListener onNavigationClickListener) {
        mtoolbar.setNavigationOnClickListener(onNavigationClickListener);
    }

    public void setTitle(String title) {
        mtoolbar.setTitle(title);
    }

    public void clearMenu() {
        mtoolbar.getMenu().clear();

    }

    public void setMenuRes(@MenuRes int menu) {
        mtoolbar.getMenu().clear();
        mtoolbar.inflateMenu(menu);

    }

    public Menu getMenu() {
        return mtoolbar.getMenu();
    }

    public ListenableTabLayout getListenableTabLayout(){
        return mTabLayout;
    }

}
