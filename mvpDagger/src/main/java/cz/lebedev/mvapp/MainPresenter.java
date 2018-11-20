package cz.lebedev.mvapp;

import javax.inject.Inject;

public interface MainPresenter {

    void onResume();

    void onUpdateButton(String item);

    void onDestroy();

    public void onFinished(String data);

    public MainView getMainView();

}
