package com.example.worldskills.emparejapp.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.worldskills.emparejapp.R;
import com.example.worldskills.emparejapp.entidades.User;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User.puntaje1=0;
        User.puntaje2=0;
    }

    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.juego:
                miIntent=new Intent(MainActivity.this,NivelActivity.class);
                break;
            case R.id.lista:
                miIntent=new Intent(getApplicationContext(),Main3Activity.class);
                break;
            case R.id.ajuste:
                miIntent=new Intent(MainActivity.this,ConfiguracionActivity.class);
                break;
        }
        startActivity(miIntent);
    }
}

