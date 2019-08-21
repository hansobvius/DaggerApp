package com.android.daggerapp.components;

import com.android.daggerapp.components.modules.ProjectModule;
import com.android.daggerapp.presenter.MainPresenter;
import com.android.daggerapp.viewModel.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ProjectModule.class)
public interface MainComponent {

    void inject(MainApplication mainApplication);

    void inject(MainPresenter mainPresenter);
}
