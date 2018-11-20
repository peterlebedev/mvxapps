package cz.lebedev.mvapp.di;

import cz.lebedev.mvapp.DataModel;
import dagger.Component;


@Component
public interface DataComponent {
   DataModel getDataModel();
}
