package com.neversettle.statusdownloader.injection.main;

import android.content.Context;

import com.neversettle.statusdownloader.ui.main.MainActivity;
import com.neversettle.statusdownloader.injection.ActivityScope;
import com.neversettle.statusdownloader.ui.main.MainContract;
import com.neversettle.statusdownloader.ui.main.MainNavigator;
import com.neversettle.statusdownloader.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private final MainActivity mainActivity;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainContract.Navigator provideMainNavigation(MainNavigator navigation) {
        return navigation;
    }

    @Provides
    @ActivityScope
    MainContract.Presenter provideMainPresenter(MainPresenter presenter) {
        return presenter;
    }

    @Provides
    @ActivityScope
    Context provideContext() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }
}
