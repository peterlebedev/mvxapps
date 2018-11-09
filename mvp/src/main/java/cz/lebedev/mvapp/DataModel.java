package cz.lebedev.mvapp;

import android.os.Handler;

public class DataModel {
    static private DataModel instance;
    String data = "some data";

    interface OnFinishedListener {
        void onFinished(String items);
    }

    private DataModel(){};

    synchronized static public DataModel getInstance() {
        if(instance == null)
            instance = new DataModel();
        return instance;
    }

    public void getData(final OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(data);
            }
        }, 2000);
    }

    public void setData(String dataupdated) {
        data  = dataupdated;
    }
}
