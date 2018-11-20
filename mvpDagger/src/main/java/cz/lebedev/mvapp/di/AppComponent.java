package cz.lebedev.mvapp.di;

import android.app.Application;
import cz.lebedev.mvapp.MainActivity;
import cz.lebedev.mvapp.MyApp;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {AndroidInjectionModule.class, ActivityBuilder.class })
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }

    void inject(MyApp myApp);
}
