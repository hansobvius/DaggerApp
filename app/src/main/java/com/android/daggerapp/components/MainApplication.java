package com.android.daggerapp.components;

import android.app.Application;

import com.android.daggerapp.components.modules.ProjectModule;

public class MainApplication extends Application {

    private static MainApplication mainApplication;

    MainComponent mainComponent;

    public static MainApplication getApp(){
        return mainApplication;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        mainApplication = this;
        initializaComponent();

        mainComponent.inject(this);
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
