package com.android.daggerapp.components.modules;

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

    public ProjectModule(MainApplication mainApplication){

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

}