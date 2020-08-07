package com.neversettle.statusdownloader.ui.main;

import com.neversettle.statusdownloader.ui.utils.BaseNavigator;
import com.neversettle.statusdownloader.ui.utils.BasePresenter;
import com.neversettle.statusdownloader.ui.utils.BaseView;

public interface MainContract {

    interface Navigator extends BaseNavigator {

        void goToWhatsApp();

        void goToInstagram();

        void goToImages();

        void goToVideos();

        boolean onBackPressed();

    }

    interface View extends BaseView {

        void closeDrawer();

        void openDrawer();

        void highlightWhatsApp();

        void highlightInstagram();

    }

    interface Presenter extends BasePresenter<View> {

        void clickWhatsApp();

        void clickInstagram();

        void clickImage();

        void clickVideo();

    }
}
