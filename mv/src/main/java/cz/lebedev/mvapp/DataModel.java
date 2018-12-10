package cz.lebedev.mvapp;




public class DataModel {

    public static final String initData = "some data";

    String data = initData;

    public String getData() {
        return data;
    }

    public void setData(String s) {
        data = s;
    }
}
