package cz.lebedev.mvapp;

import android.os.Handler;

import javax.inject.Inject;

public class DataModel {
    static private DataModel instance;
    String data = "some data";

    @Inject
    public DataModel(){};

    public String  getData() {
        return data;
    }


    public void setData(String dataupdated) {
        data = dataupdated;
    }
}
