package cz.lebedev.mvapp.di;

import cz.lebedev.mvapp.MainActivity;
import cz.lebedev.mvapp.MainPresenter;
import cz.lebedev.mvapp.MainPresenterImpl;
import cz.lebedev.mvapp.MainView;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {

    @Binds
    public abstract MainView getMainView(MainActivity mainActivity);

    @Binds
    public abstract MainPresenter getMainPresenter(MainPresenterImpl mainPresenterImpl);


}
