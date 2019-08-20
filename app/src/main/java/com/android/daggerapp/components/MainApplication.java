package com.android.daggerapp.components;

import android.app.Application;

import com.android.daggerapp.components.modules.ProjectModule;

public class MainApplication extends Application {

    private static MainApplication mainApplication;

    private MainComponent mainComponent;

    public static MainApplication getApp(){
        return mainApplication;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        mainApplication = this;
        mainComponent.inject(this);
        initializaComponent();
    }

    private void initializaComponent() {
        mainComponent = DaggerMainComponent.builder()
                .projectModule(new ProjectModule(this))
                .build();
    }

    public MainComponent getMainComponent(){
        return mainComponent;
    }
}
