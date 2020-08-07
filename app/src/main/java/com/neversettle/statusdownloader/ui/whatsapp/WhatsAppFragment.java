package com.neversettle.statusdownloader.ui.whatsapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.neversettle.statusdownloader.R;
import com.neversettle.statusdownloader.injection.whatapp.WhatsAppModule;
import com.neversettle.statusdownloader.ui.main.MainActivity;
import com.neversettle.statusdownloader.widget.CustomAppBar;
import com.neversettle.statusdownloader.widget.ListenableTabLayout;
import com.neversettle.statusdownloader.widget.TabIndicatorFollower;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WhatsAppFragment extends Fragment implements WhatsAppContract.View {

    private static final String TAG = "WhatsAppFragment";
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    SelectionsPageAdapter mSectionPageAdapter;
    @BindView(R.id.triangle)
    View triangle;

    @Inject
    WhatsAppContract.Presenter presenter;
    private MainActivity activity;
    private MyPagerAdapter myPagerAdapter;

    public static WhatsAppFragment newInstance() {
        WhatsAppFragment fragment = new WhatsAppFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
        if (context instanceof MainActivity) {
            activity = (MainActivity) context;

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_whats_app, container, false);
        //setting up view pager
        //   setUpViewPager();
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");

        inject();

        setUpViewPager();
        presenter.attachView(this);
        //  presenter.getImages();
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        setupToolbar();
    }

    private void setUpViewPager() {
        Log.d(TAG, "setUpViewPager: ");
        //setting up view pager
//        mSectionPageAdapter = new SelectionsPageAdapter(activity, activity.getSupportFragmentManager());
//        mViewPager.setAdapter(mSectionPageAdapter);
        myPagerAdapter = new MyPagerAdapter(activity.getSupportFragmentManager());
        mViewPager.setAdapter(myPagerAdapter);


        CustomAppBar appBar = (activity).getCustomAppBar();
        ListenableTabLayout mTabLayout = appBar.getListenableTabLayout();
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mTabLayout.setupWithViewPager(mViewPager);
        TabIndicatorFollower.setupWith(mTabLayout, triangle);


    }


    private void setupToolbar() {
        Log.d(TAG, "setupToolbar: ");
        CustomAppBar appBar = (activity).getCustomAppBar();
        appBar.setTitle(getString(R.string.whatsapp));
    }

    private void inject() {
        Log.d(TAG, "inject: ");
        (activity)
                .getMainComponent()
                .plus(new WhatsAppModule())
                .inject(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void highlightImages() {

    }

    @Override
    public void highlightVideos() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        presenter.detachView();
    }


}