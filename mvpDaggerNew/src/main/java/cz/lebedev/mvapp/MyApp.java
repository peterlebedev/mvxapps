package cz.lebedev.mvapp;

import android.app.Activity;
import android.app.Application;
import cz.lebedev.mvapp.di.AppComponent;
import cz.lebedev.mvapp.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerApplication;

import javax.inject.Inject;

public class MyApp extends DaggerApplication  {


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {

        AppComponent appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();
        appComponent.inject(this);
        return appComponent;
    }
}
