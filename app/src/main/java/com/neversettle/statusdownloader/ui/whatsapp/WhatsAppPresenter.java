package com.neversettle.statusdownloader.ui.whatsapp;

import android.content.Context;

import com.neversettle.statusdownloader.ui.main.MainContract;

import javax.inject.Inject;

public class WhatsAppPresenter implements WhatsAppContract.Presenter {

    private Context context;
    private WhatsAppContract.View view;
    private WhatsAppContract.Navigator navigator;

    @Inject
    public WhatsAppPresenter( WhatsAppContract.Navigator navigator) {
        this.context = context;
        this.navigator = navigator;
    }

    @Override
    public void getImages() {

    }

    @Override
    public void getVideos() {

    }

    @Override
    public void clickImage() {

    }

    @Override
    public void clickVideo() {

    }

    @Override
    public WhatsAppContract.Navigator getNavigator() {
        return null;
    }

    @Override
    public void attachView(WhatsAppContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
