package com.example.worldskills.emparejapp.actividades;

import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.emparejapp.R;
import com.example.worldskills.emparejapp.entidades.User;

import java.util.Random;

public class FacilActivity extends AppCompatActivity {

    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    TextView player1, player2, puntaje1, puntaje2;
    Drawable[] parejas = new Drawable[8];
    Drawable defecto;
    ImageView anterior, actual;
    Chronometer cronometro;
    CountDownTimer tiempo;
    int n, asigandos, asignado1, asignado2, asignado3, asignado4;
    int onClick=0,cantidadParejas=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facil);

        defecto = getResources().getDrawable(R.drawable.quien);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        puntaje1 = findViewById(R.id.puntaje1);
        puntaje2 = findViewById(R.id.puntaje2);
        cronometro = findViewById(R.id.tiempoNormal);

        player1.setText("Player 1:"+User.player1);
        player2.setText("Player 1:"+User.player2);

        if (User.tipo==1){
            cronometro.start();
        }

        generarParejas();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    onClick=1;
                    btn1.setImageDrawable(parejas[0]);
                    anterior=btn1;
                    anterior.setEnabled(false);
                }else if(onClick==1){
                    onClick=2;
                    btn1.setImageDrawable(parejas[0]);
                    actual=btn1;
                    anterior.setEnabled(false);
                    tiempo();
                    if (cantidadParejas==4){
                        termina();
                    }
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    onClick=1;
                    btn2.setImageDrawable(parejas[1]);
                    anterior=btn2;
                    anterior.setEnabled(false);
                }else if(onClick==1){
                    onClick=2;
                    btn2.setImageDrawable(parejas[1]);
                    actual=btn2;
                    anterior.setEnabled(false);
                    tiempo();
                    if (cantidadParejas==4){
                        termina();
                    }
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    onClick=1;
                    btn3.setImageDrawable(parejas[2]);
                    anterior=btn3;
                    anterior.setEnabled(false);
                }else if(onClick==1){
                    onClick=2;
                    btn3.setImageDrawable(parejas[2]);
                    actual=btn3;
                    anterior.setEnabled(false);
                    tiempo();
                    if (cantidadParejas==4){
                        termina();
                    }
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    onClick=1;
                    btn4.setImageDrawable(parejas[3]);
                    anterior=btn4;
                    anterior.setEnabled(false);
                }else if(onClick==1){
                    onClick=2;
                    btn4.setImageDrawable(parejas[3]);
                    actual=btn4;
                    anterior.setEnabled(false);
                    tiempo();
                    if (cantidadParejas==4){
                        termina();
                    }
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    onClick=1;
                    btn5.setImageDrawable(parejas[4]);
                    anterior=btn5;
                    anterior.setEnabled(false);
                }else if(onClick==1){
                    onClick=2;
                    btn5.setImageDrawable(parejas[4]);
                    actual=btn5;
                    anterior.setEnabled(false);
                    tiempo();
                    if (cantidadParejas==4){
                        termina();
                    }
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    onClick=1;
                    btn6.setImageDrawable(parejas[5]);
                    anterior=btn6;
                    anterior.setEnabled(false);
                }else if(onClick==1){
                    onClick=2;
                    btn6.setImageDrawable(parejas[5]);
                    actual=btn6;
                    anterior.setEnabled(false);
                    tiempo();
                    if (cantidadParejas==4){
                        termina();
                    }
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    onClick=1;
                    btn7.setImageDrawable(parejas[6]);
                    anterior=btn7;
                    anterior.setEnabled(false);
                }else if(onClick==1){
                    onClick=2;
                    btn7.setImageDrawable(parejas[6]);
                    actual=btn7;
                    anterior.setEnabled(false);
                    tiempo();
                    if (cantidadParejas==4){
                        termina();
                    }
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    onClick=1;
                    btn8.setImageDrawable(parejas[7]);
                    anterior=btn8;
                    anterior.setEnabled(false);
                }else if(onClick==1){
                    onClick=2;
                    btn8.setImageDrawable(parejas[7]);
                    actual=btn8;
                    anterior.setEnabled(false);
                    tiempo();
                    if (cantidadParejas==4){
                        termina();
                    }
                }
            }
        });
    }

    //Metodo que se encarga de finalizar el juego
    private void termina() {
    }


    //Compara las imagenes seleccionadas
    private void tiempo() {
        tiempo=new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (!actual.getDrawable().getConstantState().equals(anterior.getDrawable().getConstantState())){
                    actual.setImageDrawable(defecto);
                    anterior.setImageDrawable(defecto);
                    actual.setEnabled(true);
                    anterior.setEnabled(true);
                }else{
                    actual.setVisibility(View.INVISIBLE);
                    anterior.setVisibility(View.INVISIBLE);
                    actual.setEnabled(true);
                    anterior.setEnabled(true);
                }
                onClick=0;
                tiempo.cancel();
            }
        };
        tiempo.start();
    }


    //Metodo que generar las parejas aleatoriamente
    private void generarParejas() {
        while (asigandos<8){
            n=new Random().nextInt(4);
            switch (n+1){
                case 1:
                    while (asignado1<2){
                        int posicion=new Random().nextInt(8);
                        while (parejas[posicion]!=null){
                            posicion=new Random().nextInt(8);
                        }
                        parejas[posicion]=getResources().getDrawable(R.drawable.img1);
                        asigandos++;
                        asignado1++;
                    }
                    break;
                case 2:
                    while (asignado2<2){
                        int posicion=new Random().nextInt(8);
                        while (parejas[posicion]!=null){
                            posicion=new Random().nextInt(8);
                        }
                        parejas[posicion]=getResources().getDrawable(R.drawable.img2);
                        asigandos++;
                        asignado2++;
                    }
                    break;
                case 3:
                    while (asignado3<2){
                        int posicion=new Random().nextInt(8);
                        while (parejas[posicion]!=null){
                            posicion=new Random().nextInt(8);
                        }
                        parejas[posicion]=getResources().getDrawable(R.drawable.img3);
                        asigandos++;
                        asignado3++;
                    }
                    break;
                case 4:
                    while (asignado4<2){
                        int posicion=new Random().nextInt(8);
                        while (parejas[posicion]!=null){
                            posicion=new Random().nextInt(8);
                        }
                        parejas[posicion]=getResources().getDrawable(R.drawable.img4);
                        asigandos++;
                        asignado4++;
                    }
                    break;
            }
        }
    }
}
