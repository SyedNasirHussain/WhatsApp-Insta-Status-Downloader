package com.neversettle.statusdownloader.ui.utils;


public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
