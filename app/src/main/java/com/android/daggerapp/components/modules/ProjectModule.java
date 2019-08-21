package com.android.daggerapp.components.modules;

import com.android.daggerapp.adapter.MainAdapter;
import com.android.daggerapp.components.MainApplication;
import com.android.daggerapp.model.ProjectModel;
import com.android.daggerapp.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ProjectModule {

    MainApplication application;

    public ProjectModule(MainApplication application){
        this.application = application;
    }

    @Provides
    @Singleton
    List<ProjectModel> provideProjectList(){
        List<ProjectModel> items = new ArrayList<>();
        for(int i = 0; i <5 ; i++){
            ProjectModel projectModel = new ProjectModel();
            projectModel.setTitle("project " + (i + 1));
            items.add(projectModel);
        }
        return items;
    }

    @Provides
    @Singleton
    ProjectRepository providesProjectRepository(List<ProjectModel> projectModelList){
        return new ProjectRepository(projectModelList);
    }

    @Provides
    @Singleton
    MainApplication providesMainApplication(){
        return new MainApplication();
    }

    @Provides
    @Singleton
    MainAdapter providesMainAdapter(){
        return new MainAdapter(application.getApplicationContext());
    }
}
