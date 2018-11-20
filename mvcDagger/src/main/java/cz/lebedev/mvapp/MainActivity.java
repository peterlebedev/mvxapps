package cz.lebedev.mvapp;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import cz.lebedev.mvapp.di.AppComponent;
import cz.lebedev.mvapp.di.DaggerAppComponent;
import cz.lebedev.mvapp.di.MainActivityModule;
import dagger.android.AndroidInjector;


import javax.inject.Inject;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements UpdateListener{

    @Inject
    DataModel dataModel;

    @Inject
    Controller cntrl;

    TextView tv;
    private ProgressBar progressBar;
    private Button setb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //AppComponent build = DaggerAppComponent.builder().mainActivityModule(new MainActivityModule(this)).build();

        AppComponent build = DaggerAppComponent.builder().mainActivity(this).build();

        build.injectMainActivity(this);

//        dataModel = build.getDamodel();
//        cntrl = build.getController();

        progressBar = findViewById(R.id.progressBar);
        tv = findViewById(R.id.tv);


        setb = findViewById(R.id.bv_set);
        setb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar(true);
                cntrl.handleEventUpdateData(UUID.randomUUID().toString());
            }
        });

        progressBar(true);
        cntrl.update();
    }

    @Override
    public void update() {
        progressBar(false);
        String data = dataModel.getData();
        tv.setText(data);
    }

    public void progressBar(boolean show){
        if(show){
            tv.setVisibility(View.INVISIBLE);
            setb.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        }else{
            tv.setVisibility(View.VISIBLE);
            setb.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }

    }

}
