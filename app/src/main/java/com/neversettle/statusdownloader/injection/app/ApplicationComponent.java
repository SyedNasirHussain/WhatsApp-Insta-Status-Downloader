package com.neversettle.statusdownloader.injection.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Application getApplication();
}
