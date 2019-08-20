package com.android.daggerapp.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.android.daggerapp.model.ProjectModel;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    private static final ProjectRepository ourInstance = new ProjectRepository();

    public static ProjectRepository getInstance() {
        return ourInstance;
    }

    private ProjectRepository() {
    }

    public LiveData<List<ProjectModel>> getProjectList(){
        final MutableLiveData<List<ProjectModel>> data = new MutableLiveData<>();
        data.setValue(getList());
        return data;
    }

    public List<ProjectModel> getList(){
        List<ProjectModel> items = new ArrayList<>();
        for(int i = 0; i <5 ; i++){
            ProjectModel projectModel = new ProjectModel();
            projectModel.setTitle("project " + i);
            items.add(projectModel);
        }
        return items;
    }
}
