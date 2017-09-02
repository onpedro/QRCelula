package com.example.pedro.qrcelula;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_golgi extends AppCompatActivity {
    private Button btnVoltar;
    private Button btnPlay;
    private MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golgi);
        m = MediaPlayer.create(Activity_golgi.this, R.raw.complexo);
        m.start();
        final Activity activity = this;
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnPlay = (Button) findViewById(R.id.btnPlay);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.stop();
                startActivity(new Intent(Activity_golgi.this, Activity_principal.class));
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m==null){
                    m = MediaPlayer.create(Activity_golgi.this, R.raw.complexo);
                    m.start();
                }else{
                    m.start();
                }
            }
        });
    }
}
