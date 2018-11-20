package cz.lebedev.mvapp;

public class MainPresenterImpl implements  MainPresenter{

    MainView mainView;
    DataModel dataModel;

    public MainPresenterImpl(MainView mainView, DataModel dataModel){
        this.mainView = mainView;
        this.dataModel = dataModel;
    }

    @Override
    public void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }
        dataModel.getData(this::onFinished);
    }

    @Override
    public void onUpdateButton(String item) {
        if (mainView != null) {
            mainView.showProgress();
        }
        dataModel.setData(item);
        dataModel.getData(this::onFinished);
    }

    public void onDestroy() {
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
