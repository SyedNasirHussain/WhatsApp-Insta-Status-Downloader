package com.neversettle.statusdownloader.ui.whatsapp;

import com.neversettle.statusdownloader.ui.utils.BaseNavigator;
import com.neversettle.statusdownloader.ui.utils.BasePresenter;
import com.neversettle.statusdownloader.ui.utils.BaseView;

import java.util.List;

public interface WhatsAppContract {

    interface Navigator extends BaseNavigator {

        void goToImages();

        void goToVideos();

        boolean onBackPressed();

    }

    interface View extends BaseView {

        void showLoading();

        void hideLoading();

        void showToast(String message);

        void highlightImages();

        void highlightVideos();



    }

    interface Presenter extends BasePresenter<View> {

        void getImages();

        void getVideos();

        void clickImage();

        void clickVideo();

        Navigator getNavigator();


    }

}
