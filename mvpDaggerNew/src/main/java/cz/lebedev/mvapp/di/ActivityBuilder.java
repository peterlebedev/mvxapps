package cz.lebedev.mvapp.di;

import cz.lebedev.mvapp.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

//@Module(subcomponents = {MainActivityComponent.class})
@Module
public abstract class ActivityBuilder{

//    @Binds
//    @IntoMap
//    @ActivityKey(MainActivity.class)
//    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(MainActivityComponent.Builder builder);

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}



