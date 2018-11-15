package cz.lebedev.mvapp;


import android.os.Handler;

public class DataModel {
    String data = "some data";

    public String getData() {
        return data;
    }

    public void setData(final String dataupdated) {
        data  = dataupdated;
    }
}
