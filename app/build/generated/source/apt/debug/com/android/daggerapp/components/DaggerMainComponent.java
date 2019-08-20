// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.android.daggerapp.components;

import com.android.daggerapp.components.modules.ProjectModule;
import com.android.daggerapp.components.modules.ProjectModule_ProvideProjectListFactory;
import com.android.daggerapp.components.modules.ProjectModule_ProvidesProjectRepositoryFactory;
import com.android.daggerapp.model.ProjectModel;
import com.android.daggerapp.repository.ProjectRepository;
import com.android.daggerapp.viewModel.MainViewModel;
import com.android.daggerapp.viewModel.MainViewModel_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;

public final class DaggerMainComponent implements MainComponent {
  private Provider<List<ProjectModel>> provideProjectListProvider;

  private Provider<ProjectRepository> providesProjectRepositoryProvider;

  private DaggerMainComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideProjectListProvider =
        DoubleCheck.provider(ProjectModule_ProvideProjectListFactory.create(builder.projectModule));
    this.providesProjectRepositoryProvider =
        DoubleCheck.provider(
            ProjectModule_ProvidesProjectRepositoryFactory.create(
                builder.projectModule, provideProjectListProvider));
  }

  @Override
  public void inject(MainApplication mainApplication) {}

  @Override
  public void inject(MainViewModel mainViewModel) {
    injectMainViewModel(mainViewModel);
  }

  private MainViewModel injectMainViewModel(MainViewModel instance) {
    MainViewModel_MembersInjector.injectProjectRepository(
        instance, providesProjectRepositoryProvider.get());
    return instance;
  }

  public static final class Builder {
    private ProjectModule projectModule;

    private Builder() {}

    public MainComponent build() {
      if (projectModule == null) {
        throw new IllegalStateException(ProjectModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerMainComponent(this);
    }

    public Builder projectModule(ProjectModule projectModule) {
      this.projectModule = Preconditions.checkNotNull(projectModule);
      return this;
    }
  }
}