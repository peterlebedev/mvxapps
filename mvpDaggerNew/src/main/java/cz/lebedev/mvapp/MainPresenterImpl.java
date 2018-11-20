package cz.lebedev.mvapp;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter{

    @Inject
    MainView mainView;

    @Inject
    DataModel dataModel;

    @Inject
    public MainPresenterImpl(){
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

    @Override
    public void onDestroy() {
        mainView = null;
    }

    public void onFinished(String data) {
        if (mainView != null) {
            mainView.setData(data);
            mainView.hideProgress();
        }
    }

    @Override
    public MainView getMainView() {
        return mainView;
    }

}
