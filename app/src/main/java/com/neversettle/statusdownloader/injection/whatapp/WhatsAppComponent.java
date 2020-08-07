package com.neversettle.statusdownloader.injection.whatapp;


import com.neversettle.statusdownloader.injection.FragmentScope;
import com.neversettle.statusdownloader.ui.whatsapp.WhatsAppFragment;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {WhatsAppModule.class})
public interface WhatsAppComponent {

    void inject(WhatsAppFragment whatsAppFragment);
}
