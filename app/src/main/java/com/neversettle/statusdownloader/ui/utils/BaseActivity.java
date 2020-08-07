package com.neversettle.statusdownloader.ui.utils;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.neversettle.statusdownloader.app.StatusDownloaderApp;
import com.neversettle.statusdownloader.injection.app.ApplicationComponent;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(StatusDownloaderApp.getAppComponent(this));
    }

    protected abstract void setupActivityComponent(ApplicationComponent applicationComponent);


}
