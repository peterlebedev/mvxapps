package cz.lebedev.mvapp.di;

import cz.lebedev.mvapp.MainActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

//MainActivityModule poskytuje zavislosti pro danou aktivitu
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
