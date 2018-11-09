package cz.lebedev.mvapp;

import android.os.Handler;

public class DataModel {
    static private DataModel instance;
    String data = "some data";

    private DataModel(){};

    synchronized static public DataModel getInstance() {
        if(instance == null)
            instance = new DataModel();
        return instance;
    }

    public String  getData() {
        return data;
    }


    public void setData(String dataupdated) {
        data = dataupdated;
    }
}
