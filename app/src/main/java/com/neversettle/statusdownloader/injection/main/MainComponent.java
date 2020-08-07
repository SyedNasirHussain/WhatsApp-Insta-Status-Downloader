package com.neversettle.statusdownloader.injection.main;


import com.neversettle.statusdownloader.injection.whatapp.WhatsAppComponent;
import com.neversettle.statusdownloader.injection.whatapp.WhatsAppModule;
import com.neversettle.statusdownloader.ui.main.MainActivity;
import com.neversettle.statusdownloader.injection.ActivityScope;
import com.neversettle.statusdownloader.injection.app.ApplicationComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = {ApplicationComponent.class},
        modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

    WhatsAppComponent plus(WhatsAppModule whatsAppModule);
}
