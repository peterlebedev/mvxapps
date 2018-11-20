package cz.lebedev.mvapp;

import android.os.Handler;

import javax.inject.Inject;

public class DataModel {
    String data = "some data";

    interface OnFinishedListener {
        void onFinished(String items);
    }

    @Inject
    public DataModel(){};


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
