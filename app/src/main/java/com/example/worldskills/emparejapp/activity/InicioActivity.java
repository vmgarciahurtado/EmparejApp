package com.example.worldskills.emparejapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.worldskills.emparejapp.R;
import com.example.worldskills.emparejapp.entidades.User;

public class InicioActivity extends AppCompatActivity {


    EditText player1,player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);
    }

    public void onClick(View view) {
        User.player1=player1.getText().toString();
        User.player2=player2.getText().toString();
    }
}
