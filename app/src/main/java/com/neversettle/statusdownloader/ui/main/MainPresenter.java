package com.neversettle.statusdownloader.ui.main;

import android.util.Log;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {
    private static final String TAG = "MainPresenter";
    private MainContract.View view;
    private MainContract.Navigator navigator;

    @Inject
    public MainPresenter(MainContract.Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void clickWhatsApp() {
        Log.d(TAG, "clickWhatsApp: ");
        if (view != null) {
            view.highlightWhatsApp();
            view.closeDrawer();
        }
        navigator.goToWhatsApp();
    }

    @Override
    public void clickInstagram() {
        Log.d(TAG, "clickInstagram: ");
        if (view != null) {
            view.highlightInstagram();
            view.closeDrawer();
        }
        navigator.goToInstagram();
    }

    @Override
    public void clickImage() {
        Log.d(TAG, "clickImage: ");

    }

    @Override
    public void clickVideo() {

    }

    @Override
    public void attachView(MainContract.View view) {
        Log.d(TAG, "attachView: ");
        this.view = view;
    }

    @Override
    public void detachView() {
        Log.d(TAG, "detachView: ");
        this.view = null;
    }

}
