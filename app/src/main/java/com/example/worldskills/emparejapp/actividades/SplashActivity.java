package com.example.worldskills.emparejapp.actividades;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.worldskills.emparejapp.R;

public class SplashActivity extends AppCompatActivity {


    CountDownTimer tiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tiempo=new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent miIntent=new Intent(SplashActivity.this,InicioActivity.class);
                startActivity(miIntent);
                finish();
            }
        };
        tiempo.start();
    }
}
