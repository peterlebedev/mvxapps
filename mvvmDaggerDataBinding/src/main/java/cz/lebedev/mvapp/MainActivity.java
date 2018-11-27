package cz.lebedev.mvapp;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;
import cz.lebedev.mvapp.databinding.ActivityMainBinding;

import javax.inject.Inject;
import java.util.UUID;

public class MainActivity extends DaggerAppCompatActivity {

    private DataViewModel dataViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private ActivityMainBinding  viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        dataViewModel = ViewModelProviders.of(this,viewModelFactory).get(DataViewModel.class);
        viewDataBinding.setShowProgress(true);
        dataViewModel.getData().observe(this, s -> {
            viewDataBinding.setData(s);
            viewDataBinding.setShowProgress(false);
        });

        viewDataBinding.bvSet.setOnClickListener(v -> {
            viewDataBinding.setShowProgress(true);
            dataViewModel.setData(UUID.randomUUID().toString());
        });
    }
}
