package cz.lebedev.mvapp;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;
import dagger.android.support.DaggerAppCompatActivity;

import javax.inject.Inject;
import java.util.UUID;

public class MainActivity extends DaggerAppCompatActivity implements MainView {

    private ProgressBar progressBar;

    @Inject
    MainPresenter presenter;
    TextView tv;
    private Button setb;

    @Inject
    DataModel dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        setb = findViewById(R.id.bv_set);
        progressBar = findViewById(R.id.progress);

        setb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onUpdateButton(UUID.randomUUID().toString());
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        tv.setVisibility(View.INVISIBLE);
        setb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        tv.setVisibility(View.VISIBLE);
        setb.setVisibility(View.VISIBLE);
    }

    @Override
    public void setData(String item) {
        tv.setText(item);
    }

}
