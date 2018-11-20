package cz.lebedev.mvapp.di;


import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import cz.lebedev.mvapp.DataViewModel;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {


    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @Inject
    public ViewModelFactory(ViewModelSubComponent viewModelSubComponent){
        this.creators = new ArrayMap<Class<? extends ViewModel>, Provider<ViewModel>>();
        //creators[DirectoryViewModel::class.java] = Callable{viewModelSubComponent.directoryViewModel()}

        creators.put(DataViewModel.class, new Provider<ViewModel>() {
            @Override
            public ViewModel get() {
                return viewModelSubComponent.dataViewModel();
            }
        });

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<ViewModel> creator = creators.get(modelClass);
        if (creator == null) {
            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }
        try {
            return (T) creator.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
