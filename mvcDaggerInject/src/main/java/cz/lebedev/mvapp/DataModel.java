package cz.lebedev.mvapp;

import javax.inject.Inject;

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
