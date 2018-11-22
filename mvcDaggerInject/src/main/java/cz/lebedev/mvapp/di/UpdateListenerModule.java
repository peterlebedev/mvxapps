package cz.lebedev.mvapp.di;

import cz.lebedev.mvapp.MainActivity;
import cz.lebedev.mvapp.UpdateListener;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class UpdateListenerModule {

    @Binds
    public abstract UpdateListener updateListener(MainActivity mainActivity);

}
