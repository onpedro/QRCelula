package com.example.pedro.qrcelula;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarPrincipal();
            }
        },3000);
        m = MediaPlayer.create(MainActivity.this,R.raw.m);
        m.start();

    }
    public void mostrarPrincipal(){
        Intent intent = new Intent(MainActivity.this, Activity_principal.class);
        startActivity(intent);
        finish();
    }
}
