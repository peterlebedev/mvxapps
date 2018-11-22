package cz.lebedev.mvapp.di;

import cz.lebedev.mvapp.MainActivity;
import cz.lebedev.mvapp.UpdateListener;
import dagger.Module;
import dagger.Provides;

@Module
public class UpdateListenerModule {

    @Provides
    public UpdateListener updateListener(MainActivity mainActivity){
        return mainActivity;
    }

}
