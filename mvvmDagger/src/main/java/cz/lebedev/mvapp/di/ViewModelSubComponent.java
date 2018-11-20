package cz.lebedev.mvapp.di;

import cz.lebedev.mvapp.DataViewModel;
import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder{
        ViewModelSubComponent build();
    }

    DataViewModel dataViewModel();
}
