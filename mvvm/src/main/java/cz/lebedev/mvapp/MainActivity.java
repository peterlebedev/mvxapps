package cz.lebedev.mvapp;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    TextView tv;
    private Button setb;
    private DataViewModel dataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        setb = findViewById(R.id.bv_set);
        progressBar = findViewById(R.id.progress);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
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
