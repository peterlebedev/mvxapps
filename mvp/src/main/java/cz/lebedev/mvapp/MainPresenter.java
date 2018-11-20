package cz.lebedev.mvapp;

public interface MainPresenter {


    void onResume();

    void onUpdateButton(String item);

    void onDestroy();

    public void onFinished(String data);

    public MainView getMainView();

}
