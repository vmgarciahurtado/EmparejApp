package com.example.worldskills.emparejapp.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.worldskills.emparejapp.R;

public class NivelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);

    }

    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.facil:
                miIntent=new Intent(NivelActivity.this,FacilActivity.class);
                finish();
                break;
            case R.id.medio:
                break;
            case R.id.dificil:
                break;
        }
        startActivity(miIntent);
    }
}
