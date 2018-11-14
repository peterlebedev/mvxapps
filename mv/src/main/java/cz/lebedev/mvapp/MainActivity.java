package cz.lebedev.mvapp;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

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
        dataModel = new DataModel();

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
