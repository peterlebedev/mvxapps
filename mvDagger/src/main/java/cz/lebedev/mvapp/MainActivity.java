package cz.lebedev.mvapp;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import cz.lebedev.mvapp.di.DaggerDataComponent;
import cz.lebedev.mvapp.di.DataComponent;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

import javax.inject.Inject;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ProgressBar progressBar;
    private Button bt;
    private DataModel dataModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataComponent dataComponent = DaggerDataComponent.builder().build();
        dataModel = dataComponent.getDataModel();

        tv = findViewById(R.id.tv);
        progressBar = findViewById(R.id.progressBar);
        bt = findViewById(R.id.but_update);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataModel.setData(UUID.randomUUID().toString());
                        reload();
                    }
                },2000);
            }
        });

        reload();
    }

    public void reload(){
        String data = dataModel.getData();
        tv.setText(data);
        progressBar(false);
    }

    public void progressBar(boolean show){
        if(show){
            tv.setVisibility(View.INVISIBLE);
            bt.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        }else{
            tv.setVisibility(View.VISIBLE);
            bt.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }

    }

}
