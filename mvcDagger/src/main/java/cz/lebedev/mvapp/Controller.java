package cz.lebedev.mvapp;

import android.os.Handler;

import javax.inject.Inject;

public class Controller {

    DataModel dataModel;
    UpdateListener updateListener;

    @Inject
    public Controller(UpdateListener updateListener, DataModel dataModel){
        this.dataModel = dataModel;
        this.updateListener = updateListener;
    }

    public void update(){
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
