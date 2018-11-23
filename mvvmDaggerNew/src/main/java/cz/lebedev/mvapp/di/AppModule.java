package cz.lebedev.mvapp.di;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

//@Module(subcomponents = {ViewModelSubComponent.class})
@Module(includes = {ViewModelModule.class})
public class AppModule {

//    @Provides
//    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder builder){
//            ViewModelSubComponent build = builder.build();
//            ViewModelFactory viewModelFactory = new ViewModelFactory(build);
//            return viewModelFactory;
//    }
}
