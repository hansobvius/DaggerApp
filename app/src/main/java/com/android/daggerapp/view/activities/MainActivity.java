package com.android.daggerapp.view.activities;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.daggerapp.R;
import com.android.daggerapp.adapter.MainAdapter;
import com.android.daggerapp.databinding.ActivityMainBinding;
import com.android.daggerapp.model.ProjectModel;
import com.android.daggerapp.presenter.MainContractor;
import com.android.daggerapp.presenter.MainPresenter;
import com.android.daggerapp.viewModel.MainViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LifecycleOwner, MainContractor.MainView {

    @Inject
    MainAdapter mainAdapter;

    @BindView(R.id.project_list)
    ListView projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        projectList.setAdapter(mainAdapter);

    }

    @Override
    protected void onStart(){
        super.onStart();
        final MainPresenter mainPresenter = ViewModelProviders.of(this).get(MainPresenter.class);
        mainPresenter.setUpPresenter(this);
        observeMainPresenter(mainPresenter);
    }

    private void observeMainPresenter(MainPresenter mainPresenter) {
        mainPresenter.getProjectListObservable().observe(this, new Observer<List<ProjectModel>>() {
            @Override
            public void onChanged(@Nullable List<ProjectModel> projectModels) {
                mainAdapter.addItems(projectModels);
            }
        });
    }
}
