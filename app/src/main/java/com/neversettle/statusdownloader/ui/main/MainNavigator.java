package com.neversettle.statusdownloader.ui.main;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.neversettle.statusdownloader.R;
import com.neversettle.statusdownloader.ui.instagram.InstagramFragment;
import com.neversettle.statusdownloader.ui.whatsapp.WhatsAppFragment;

import javax.inject.Inject;


public class MainNavigator implements MainContract.Navigator {

    private static final String TAG = "MainNavigator";
    private static final String TAG_DETAILS = "tag_details";
    private static final String TAG_MASTER = "tag_master";
    private static final String TAG_PRO_FINAL_SUCCESS = "tag_prod_final_success";
    private static final String TAG_PRO_FINAL_FAILED = "tag_prod_final_failed";
    private MainActivity mainActivity;


    @Inject
    public MainNavigator(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    private boolean clearDetails() {
        Log.d(TAG, "clearDetails: ");
        final Fragment details = mainActivity.getSupportFragmentManager().findFragmentByTag(TAG_DETAILS);
        if (details != null) {
            mainActivity.getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .remove(details)
                    .commitNow();
            return true;
        }
        return false;
    }

    private void clearMaster() {
        Log.d(TAG, "clearMaster: ");
        Fragment master = mainActivity.getSupportFragmentManager().findFragmentByTag(TAG_MASTER);
        if (master != null) {
            mainActivity.getSupportFragmentManager().beginTransaction().remove(master).commitNow();
        }
    }
    @Override
    public void goToWhatsApp() {
        Log.d(TAG, "goToWhatsApp: ");
        clearDetails();
        WhatsAppFragment fragment = WhatsAppFragment.newInstance();
        mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.activity_main__frame_master, fragment, TAG_MASTER).commitNow();
    }

    @Override
    public void goToInstagram() {
        Log.d(TAG, "goToInstagram: ");
        clearDetails();
        InstagramFragment fragment = InstagramFragment.newInstance();
        mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.activity_main__frame_master, fragment, TAG_MASTER).commitNow();
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

