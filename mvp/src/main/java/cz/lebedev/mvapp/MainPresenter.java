package cz.lebedev.mvapp;

public class MainPresenter {

    MainView mainView;
    DataModel dataModel;

    public MainPresenter(MainView mainView, DataModel dataModel){
        this.mainView = mainView;
        this.dataModel = dataModel;
    }

    void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }
        dataModel.getData(this::onFinished);
    }

    void onUpdateButton(String item) {
        if (mainView != null) {
            mainView.showProgress();
        }
        dataModel.setData(item);
        dataModel.getData(this::onFinished);
    }

    void onDestroy() {
        mainView = null;
    }

    public void onFinished(String data) {
        if (mainView != null) {
            mainView.setData(data);
            mainView.hideProgress();
        }
    }

    public MainView getMainView() {
        return mainView;
    }

}
