package cz.lebedev.mvapp;

import android.os.Handler;

public class Controller {

    UpdateListener updateListener;
    DataModel dataModel;

    public Controller(UpdateListener updateListener, DataModel dataModel){
        this.updateListener = updateListener;
        this.dataModel = dataModel;
        updateListener.update();
    }


    public void handleEventUpdateData(final String dataupdated) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dataModel.setData(dataupdated);
                updateListener.update();
            }
        },2000);

    }

}
