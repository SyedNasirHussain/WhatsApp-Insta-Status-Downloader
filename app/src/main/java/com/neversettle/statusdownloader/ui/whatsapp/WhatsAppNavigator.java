package com.neversettle.statusdownloader.ui.whatsapp;

import com.neversettle.statusdownloader.ui.main.MainContract;

import javax.inject.Inject;

public class WhatsAppNavigator implements WhatsAppContract.Navigator {

    MainContract.Navigator navigator;

    @Inject
    public WhatsAppNavigator(MainContract.Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void goToImages() {

    }

    @Override
    public void goToVideos() {

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
