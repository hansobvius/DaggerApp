package com.android.daggerapp.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.android.daggerapp.model.ProjectModel;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    private List<ProjectModel> projectModelList;

    public ProjectRepository(List<ProjectModel> projectModelList) {
        this.projectModelList = projectModelList;
    }

    public LiveData<List<ProjectModel>> getProjectList(){
        final MutableLiveData<List<ProjectModel>> data = new MutableLiveData<>();
        data.setValue(projectModelList);
        return data;
    }
}
