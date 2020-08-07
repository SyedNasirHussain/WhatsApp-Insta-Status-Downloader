package com.neversettle.statusdownloader.injection.whatapp;


import com.neversettle.statusdownloader.injection.FragmentScope;
import com.neversettle.statusdownloader.ui.whatsapp.WhatsAppContract;
import com.neversettle.statusdownloader.ui.whatsapp.WhatsAppNavigator;
import com.neversettle.statusdownloader.ui.whatsapp.WhatsAppPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class WhatsAppModule {
    @Provides
    WhatsAppContract.Navigator provideWhatsAppNavigator(WhatsAppNavigator navigator) {
        return navigator;
    }

    @FragmentScope
    @Provides
    WhatsAppContract.Presenter provideWhatsAppPresenter(WhatsAppPresenter presenter) {
        return presenter;
    }
}
