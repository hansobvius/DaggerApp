package com.android.daggerapp.presenter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.android.daggerapp.components.MainApplication;
import com.android.daggerapp.model.ProjectModel;
import com.android.daggerapp.repository.ProjectRepository;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter extends AndroidViewModel implements MainContractor.Presenter {

    public final LiveData<List<ProjectModel>> projectListing;

    @Inject
    ProjectRepository projectRepository;

    MainContractor.MainView mainView;

    @Inject
    public MainPresenter(Application application){
        super(application);
        MainApplication.getApp().getMainComponent().inject(this);
        projectListing = projectRepository.getProjectList();
    }

    public LiveData<List<ProjectModel>> getProjectListObservable(){
        return projectListing;
    }

    @Override
    public void setUpPresenter(MainContractor.MainView mainView) {
        this.mainView = mainView;
    }
}
