package com.example.pedro.qrcelula;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Activity_principal extends AppCompatActivity {
private Button btnSobre;
private Button btnAcesso;
    private MediaPlayer m;
    VideoView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        view = (VideoView)findViewById(R.id.videoView2);
        String path = "android.resource://" +getPackageName()+"/"+R.raw.videointro;
        view.setVideoURI(Uri.parse(path));
        view.seekTo(0);
        view.start();

        btnSobre = (Button) findViewById(R.id.btnNos);
        btnAcesso = (Button) findViewById(R.id.btnAcessar);

        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_principal.this, Activity_nos.class));
            }
        });

        btnAcesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(Activity_principal.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Bem vindo ao scanner!");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null){
            if (result.getContents()==null){
                Toast.makeText(this, "Você cancelou o scanner!", Toast.LENGTH_LONG).show();

            }else {
                String n = result.getContents();
                if (n.equals("mitocondria")){
                    Toast.makeText(this, "Mitocôndria", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Activity_principal.this, Activity_info.class));
                }else if (n.equals("complexo de golgi")){
                    Toast.makeText(this, "Complexo de Golgi", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Activity_principal.this, Activity_golgi.class));
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
