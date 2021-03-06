package cz.lebedev.mvapp.di;


import cz.lebedev.mvapp.Controller;
import cz.lebedev.mvapp.DataModel;
import cz.lebedev.mvapp.MainActivity;
import cz.lebedev.mvapp.UpdateListener;
import dagger.BindsInstance;
import dagger.Component;


@MyScope
@Component(modules = {MainActivityModule.class, UpdateListenerModule.class})

public interface AppComponent {
    DataModel getDamodel();
    Controller getController();
}
