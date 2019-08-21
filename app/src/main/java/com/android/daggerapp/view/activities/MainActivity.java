package com.android.daggerapp.view.activities;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.daggerapp.R;
import com.android.daggerapp.adapter.MainAdapter;
import com.android.daggerapp.components.MainApplication;
import com.android.daggerapp.databinding.ActivityMainBinding;
import com.android.daggerapp.model.ProjectModel;
import com.android.daggerapp.viewModel.MainViewModel;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    ActivityMainBinding binding;

    @Inject
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.getApp().getMainComponent().inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.projectList.setAdapter(mainAdapter);
    }

    @Override
    protected void onStart(){
        super.onStart();
        final MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        observeViewModel(viewModel);
    }

    private void observeViewModel(MainViewModel viewModel) {
        viewModel.getProjectListObservable().observe(this, new Observer<List<ProjectModel>>() {
            @Override
            public void onChanged(@Nullable List<ProjectModel> projectModels) {
                mainAdapter.addItems(projectModels);
            }
        });
    }
}
