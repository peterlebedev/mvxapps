package cz.lebedev.mvapp;

import android.os.Handler;

public class Controller {

    UpdateListener updateListener;

    public Controller(UpdateListener updateListener){
        this.updateListener = updateListener;
        updateListener.update();
    }


    public void handleEventUpdateData(final String dataupdated) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DataModel.getInstance().setData(dataupdated);
                updateListener.update();
            }
        },2000);

    }

}
