package cz.lebedev.mvapp;

import cz.lebedev.mvapp.di.MyScope;

import javax.inject.Inject;

@MyScope
public class DataModel {
    String data = "some data";

    @Inject
    public DataModel(){};

    public String getData() {
        return data;
    }

    public void setData(final String dataupdated) {
        data  = dataupdated;
    }
}
