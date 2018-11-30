package cz.lebedev.mvapp;

import android.app.Application;
import android.os.Handler;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import javax.inject.Inject;
import java.util.UUID;

public class DataViewModel extends AndroidViewModel {

    public MutableLiveData<String> data = new MutableLiveData<String>();
    public ObservableField<Boolean> loading = new ObservableField<>();

    DataModel dataModel;

    @Inject
    public DataViewModel(Application app){
        super(app);
        loading.set(true);
        dataModel = new DataModel();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                reload();
            }
        },2000);    }

    private void reload() {
        String dataFromModel = dataModel.getData();
        data.postValue(dataFromModel);
        loading.set(false);
    }

    public LiveData<String> getData() {
        return data;
    }

    public void setData(String s) {
        loading.set(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dataModel.setData(s);
                reload();
            }
        },2000);
    }

    public void onClickUpdate(){
        setData(UUID.randomUUID().toString());
    }

 }
