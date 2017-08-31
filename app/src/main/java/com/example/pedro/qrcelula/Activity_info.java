package com.example.pedro.qrcelula;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class
Activity_info extends AppCompatActivity {
private Button btnVoltar;
private Button btnPlay;
    private MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        final Activity activity = this;
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnPlay = (Button) findViewById(R.id.btnPlay);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_info.this , Activity_principal.class));
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m == null){
                    m = MediaPlayer.create(Activity_info.this, R.raw.stuck);
                    m.start();
                }else{
                    m.start();
                }
            }
        });
    }
}
