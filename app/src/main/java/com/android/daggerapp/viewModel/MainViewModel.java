package com.android.daggerapp.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.daggerapp.R;
import com.android.daggerapp.components.MainApplication;
import com.android.daggerapp.model.ProjectModel;
import com.android.daggerapp.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends AndroidViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }
}
