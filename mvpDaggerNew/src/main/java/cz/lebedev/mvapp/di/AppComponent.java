package cz.lebedev.mvapp.di;

import android.app.Application;
import cz.lebedev.mvapp.MyApp;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Component(modules = {AndroidSupportInjectionModule.class, ActivityBuilder.class })
public interface AppComponent  extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }

    @Override
    void inject(DaggerApplication instance);


    void inject(MyApp myApp);
}
