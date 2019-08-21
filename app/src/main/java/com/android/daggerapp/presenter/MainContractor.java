package com.android.daggerapp.presenter;

public interface MainContractor {

    interface MainView{}

    interface Presenter{
        void setUpPresenter(MainView mainView);
    }
}
