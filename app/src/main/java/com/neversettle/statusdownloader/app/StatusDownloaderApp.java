package com.neversettle.statusdownloader.app;

import android.app.Application;
import android.content.Context;

import com.neversettle.statusdownloader.injection.app.ApplicationComponent;
import com.neversettle.statusdownloader.injection.app.ApplicationModule;
import com.neversettle.statusdownloader.injection.app.DaggerApplicationComponent;



public class StatusDownloaderApp extends Application {

   private ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();


        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();


    }

    public static ApplicationComponent getAppComponent(Context context) {
        return ((StatusDownloaderApp) context.getApplicationContext()).applicationComponent;
    }

}
