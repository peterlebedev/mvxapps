package cz.lebedev.mvapp;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

import javax.inject.Inject;
import java.util.UUID;


public class MainActivity extends DaggerAppCompatActivity {

    private ProgressBar progressBar;
    TextView tv;
    private Button setb;
    private DataViewModel dataViewModel;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        setb = findViewById(R.id.bv_set);
        progressBar = findViewById(R.id.progress);

        dataViewModel = ViewModelProviders.of(this,viewModelFactory).get(DataViewModel.class);
        dataViewModel.getData().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        progressBar(false);
                        progressBar.setVisibility(View.INVISIBLE);
                        tv.setText(s);
                    }
                });

        setb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar(true);
                dataViewModel.setData(UUID.randomUUID().toString());
            }
        });
    }

    private void progressBar(boolean show) {
        if(show) {
            tv.setVisibility(View.GONE);
            setb.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.GONE);
            tv.setVisibility(View.VISIBLE);
            setb.setVisibility(View.VISIBLE);
        }
    }

}
