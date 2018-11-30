package cz.lebedev.mvapp;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;
import cz.lebedev.mvapp.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends DaggerAppCompatActivity {

    private DataViewModel dataViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private ActivityMainBinding  viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewDataBinding.setLifecycleOwner(this);

        dataViewModel = ViewModelProviders.of(this,viewModelFactory).get(DataViewModel.class);
        viewDataBinding.setViewModel(dataViewModel);
    }
}
