package cz.lebedev.mvapp.di;


import cz.lebedev.mvapp.MainActivity;
import dagger.BindsInstance;
import dagger.Component;


//SOLUTION1 @Component(modules = {MainActivityModule.class, UpdateListenerModule.class})
@MyScope
@Component(modules = {UpdateListenerModule.class})
public interface AppComponent {
    //SOLUTION1 DataModel getDamodel();
    //SOLUTION1 Controller getController();

  //vyplni @Inject zavislosti
    void injectMainActivity(MainActivity mainActivity);

    //pripoji objekt potrebny pro vytvoreni UpdateListener
    @Component.Builder
    interface Builder{
        AppComponent build();
        @BindsInstance Builder mainActivity(MainActivity mainActivity);
    }

}
