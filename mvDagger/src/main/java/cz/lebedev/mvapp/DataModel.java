package cz.lebedev.mvapp;


import javax.inject.Inject;

public class DataModel {

    String  data = "data";

    @Inject
    public DataModel(){
    }

    public String getData() {
        return data;
    }

    public void setData(String s) {
        data = s;
    }
}
