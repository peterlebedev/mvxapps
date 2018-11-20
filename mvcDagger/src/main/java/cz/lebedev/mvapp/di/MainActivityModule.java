package cz.lebedev.mvapp.di;

import cz.lebedev.mvapp.MainActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Provides
    public MainActivity getMainActivity() {
        return mainActivity;
    }
}
