package cz.lebedev.mvapp;

import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

class DataViewModel extends ViewModel {
    public MutableLiveData<String> data = new MutableLiveData<String>();

    public DataViewModel(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                reload();
            }
        },2000);    }

    private void reload() {
        String dataFromModel = DataModel.getInstance().getData();
        data.postValue(dataFromModel);
    }

    public LiveData<String> getData() {
        return data;
    }

    public void setData(String s) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DataModel.getInstance().setData(s);
                reload();
            }
        },2000);
    }
}
