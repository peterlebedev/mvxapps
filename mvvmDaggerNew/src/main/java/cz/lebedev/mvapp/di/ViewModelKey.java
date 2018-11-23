package cz.lebedev.mvapp.di;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
