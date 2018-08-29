package com.example.worldskills.emparejapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.worldskills.emparejapp.R;

public class InicioActivity extends AppCompatActivity {


    EditText player1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void onClick(View view) {
    }
}
