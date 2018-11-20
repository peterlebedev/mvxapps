package cz.lebedev.mvapp.di;

import cz.lebedev.mvapp.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector
    public abstract MainActivity contributeMainActivity();
}
