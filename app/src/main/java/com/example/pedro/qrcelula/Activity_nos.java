package com.example.pedro.qrcelula;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_nos extends AppCompatActivity {
private Button btnVolta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nos);
        final Activity activity = this;

        btnVolta = (Button) findViewById(R.id.btnVoltar);

        btnVolta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_nos.this, Activity_principal.class));
            }
        });
    }
}
