package com.example.worldskills.emparejapp.actividades;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.worldskills.emparejapp.R;
import com.example.worldskills.emparejapp.entidades.User;
import com.example.worldskills.emparejapp.utilidades.Conexion;
import com.example.worldskills.emparejapp.utilidades.Utilidades;

import java.util.Random;

public class DificilActivity extends AppCompatActivity {

    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16;
    TextView player1, player2, puntaje1, puntaje2, tiempoTotal;
    LinearLayout primero, segundo;
    Drawable[] parejas = new Drawable[16];
    Drawable defecto;
    ImageView anterior, actual;
    Chronometer cronometro;
    CountDownTimer tiempo, timerTotal;
    int n, jugador, asigandos, asignado1, asignado2, asignado3, asignado4, asignado5, asignado6, asignado7, asignado8;
    int onClick = 0, cantidadParejas = 0;
    Conexion conn;
    SQLiteDatabase bd;

    MediaPlayer win, lose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificil);
        conn = new Conexion(getApplicationContext(), "Puntaje", null, 1);
        defecto = getResources().getDrawable(R.drawable.quien);
        btn1 = findViewById(R.id.btn1m);
        btn2 = findViewById(R.id.btn2m);
        btn3 = findViewById(R.id.btn3m);
        btn4 = findViewById(R.id.btn4m);
        btn5 = findViewById(R.id.btn5m);
        btn6 = findViewById(R.id.btn6m);
        btn7 = findViewById(R.id.btn7m);
        btn8 = findViewById(R.id.btn8m);
        btn9 = findViewById(R.id.btn9m);
        btn10 = findViewById(R.id.btn10m);
        btn11 = findViewById(R.id.btn11m);
        btn12 = findViewById(R.id.btn12m);
        btn13 = findViewById(R.id.btn13m);
        btn14 = findViewById(R.id.btn14m);
        btn15 = findViewById(R.id.btn15m);
        btn16 = findViewById(R.id.btn16m);
        player1 = findViewById(R.id.player1m);
        player2 = findViewById(R.id.player2m);
        puntaje1 = findViewById(R.id.puntaje1m);
        puntaje2 = findViewById(R.id.puntaje2m);
        cronometro = findViewById(R.id.tiempoNormalm);
        tiempoTotal = findViewById(R.id.tiempom);
        primero = findViewById(R.id.primerom);
        segundo = findViewById(R.id.segundom);
        win = MediaPlayer.create(this, R.raw.win1);
        lose = MediaPlayer.create(this, R.raw.lose1);

        player1.setText("Player 1:" + User.player1);
        player2.setText("Player 1:" + User.player2);

        if (User.tipo == 1) {
            cronometro.start();
            cronometro.setVisibility(View.VISIBLE);
            tiempoTotal.setVisibility(View.INVISIBLE);
        } else if (User.tipo == 2) {
            cronometro.setVisibility(View.INVISIBLE);
            tiempoTotal.setVisibility(View.VISIBLE);
            tiempoReversa();
        }

        generarJugador();
        generarParejas();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn1.setImageDrawable(parejas[0]);
                    anterior = btn1;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn1.setImageDrawable(parejas[0]);
                    actual = btn1;
                    anterior.setEnabled(false);
                    tiempo();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn2.setImageDrawable(parejas[1]);
                    anterior = btn2;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn2.setImageDrawable(parejas[1]);
                    actual = btn2;
                    anterior.setEnabled(false);
                    tiempo();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn3.setImageDrawable(parejas[2]);
                    anterior = btn3;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn3.setImageDrawable(parejas[2]);
                    actual = btn3;
                    anterior.setEnabled(false);
                    tiempo();

                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn4.setImageDrawable(parejas[3]);
                    anterior = btn4;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn4.setImageDrawable(parejas[3]);
                    actual = btn4;
                    anterior.setEnabled(false);
                    tiempo();
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn5.setImageDrawable(parejas[4]);
                    anterior = btn5;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn5.setImageDrawable(parejas[4]);
                    actual = btn5;
                    anterior.setEnabled(false);
                    tiempo();

                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn6.setImageDrawable(parejas[5]);
                    anterior = btn6;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn6.setImageDrawable(parejas[5]);
                    actual = btn6;
                    anterior.setEnabled(false);
                    tiempo();

                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn7.setImageDrawable(parejas[6]);
                    anterior = btn7;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn7.setImageDrawable(parejas[6]);
                    actual = btn7;
                    anterior.setEnabled(false);
                    tiempo();
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn8.setImageDrawable(parejas[7]);
                    anterior = btn8;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn8.setImageDrawable(parejas[7]);
                    actual = btn8;
                    anterior.setEnabled(false);
                    tiempo();

                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn9.setImageDrawable(parejas[8]);
                    anterior = btn9;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn9.setImageDrawable(parejas[8]);
                    actual = btn9;
                    anterior.setEnabled(false);
                    tiempo();

                }
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn10.setImageDrawable(parejas[9]);
                    anterior = btn10;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn10.setImageDrawable(parejas[9]);
                    actual = btn10;
                    anterior.setEnabled(false);
                    tiempo();

                }
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn11.setImageDrawable(parejas[10]);
                    anterior = btn11;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn11.setImageDrawable(parejas[10]);
                    actual = btn11;
                    anterior.setEnabled(false);
                    tiempo();
                }
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn12.setImageDrawable(parejas[11]);
                    anterior = btn12;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn12.setImageDrawable(parejas[11]);
                    actual = btn12;
                    anterior.setEnabled(false);
                    tiempo();

                }
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn13.setImageDrawable(parejas[12]);
                    anterior = btn13;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn13.setImageDrawable(parejas[12]);
                    actual = btn13;
                    anterior.setEnabled(false);
                    tiempo();

                }
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn14.setImageDrawable(parejas[13]);
                    anterior = btn14;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn14.setImageDrawable(parejas[13]);
                    actual = btn14;
                    anterior.setEnabled(false);
                    tiempo();

                }
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn15.setImageDrawable(parejas[14]);
                    anterior = btn15;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn15.setImageDrawable(parejas[14]);
                    actual = btn15;
                    anterior.setEnabled(false);
                    tiempo();
                }
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    onClick = 1;
                    btn16.setImageDrawable(parejas[15]);
                    anterior = btn16;
                    anterior.setEnabled(false);
                } else if (onClick == 1) {
                    onClick = 2;
                    btn16.setImageDrawable(parejas[15]);
                    actual = btn16;
                    anterior.setEnabled(false);
                    tiempo();

                }
            }
        });
    }

    private void tiempoReversa() {
        timerTotal = new CountDownTimer(User.tiempo, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempoTotal.setText(" " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                termina();
            }
        };
        timerTotal.start();
    }

    //Me Indica que jugador empieza
    private void generarJugador() {
        jugador = (int) Math.floor(Math.random() * 2) + 1;
        User.activo = jugador;
        colores();
    }

    private void colores() {
        if (User.activo == 1) {
            player1.setTextColor(Color.parseColor("#000000"));
            puntaje1.setTextColor(Color.parseColor("#000000"));
            player2.setTextColor(Color.parseColor("#898989"));
            puntaje2.setTextColor(Color.parseColor("#898989"));
            primero.setBackgroundColor(Color.parseColor("#56ff5c"));
            segundo.setBackgroundColor(Color.parseColor("#00ff0000"));
        } else if (User.activo == 2) {
            player2.setTextColor(Color.parseColor("#000000"));
            puntaje2.setTextColor(Color.parseColor("#000000"));
            player1.setTextColor(Color.parseColor("#898989"));
            puntaje1.setTextColor(Color.parseColor("#898989"));
            segundo.setBackgroundColor(Color.parseColor("#56ff5c"));
            primero.setBackgroundColor(Color.parseColor("#00ff0000"));
        }
    }

    //Metodo que se encarga de finalizar el juego
    private void termina() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Finaliza");
        String mensaje = "";
        mensaje += "Player 1: " + User.player1 + " \n";
        mensaje += "Puntaje: " + User.puntaje1 + " \n\n";
        mensaje += "Player 2: " + User.player2 + " \n";
        mensaje += "Puntaje: " + User.puntaje2 + " \n\n";
        if (User.tipo == 1) {
            cronometro.stop();
            mensaje += "Tiempo " + cronometro.getContentDescription();
        } else if (User.tipo == 2) {
            mensaje += "Tiempo Limite" + User.tiempo / 1000;
        }
        builder.setMessage(mensaje);


        builder.setNeutralButton("Publicar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                publicar();
            }
        });
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (User.tipo == 1) {
                    registrar();
                } else {
                    User.puntaje1 = 0;
                    User.puntaje2 = 0;
                    timerTotal.cancel();
                    finish();
                }

            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }

    //Metodo para registaren Sql
    private void registrar() {
        bd = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_JUGADOR, User.player1);
        values.put(Utilidades.CAMPO_PUNTAJE, User.puntaje1);
        values.put(Utilidades.CAMPO_NIVEL, 3);

        bd.insert(Utilidades.TABLA_JUEGO, Utilidades.CAMPO_PUNTAJE, values);

        values = new ContentValues();
        values.put(Utilidades.CAMPO_JUGADOR, User.player2);
        values.put(Utilidades.CAMPO_PUNTAJE, User.puntaje2);
        values.put(Utilidades.CAMPO_NIVEL, 3);

        bd.insert(Utilidades.TABLA_JUEGO, Utilidades.CAMPO_PUNTAJE, values);


        User.puntaje1 = 0;
        User.puntaje2 = 0;
        cronometro.stop();
        finish();
    }


    //Metodo para publicar en redes sociales
    private void publicar() {

    }


    //Compara las imagenes seleccionadas
    private void tiempo() {
        tiempo = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (!actual.getDrawable().getConstantState().equals(anterior.getDrawable().getConstantState())) {
                    actual.setImageDrawable(defecto);
                    anterior.setImageDrawable(defecto);
                    actual.setEnabled(true);
                    anterior.setEnabled(true);
                    lose.start();
                    if (User.activo == 1) {
                        if (User.puntaje1 >= 2) {
                            User.puntaje1 = User.puntaje1 - 2;
                        }
                        User.activo = 2;
                    } else if (User.activo == 2) {
                        if (User.puntaje2 >= 2) {
                            User.puntaje2 = User.puntaje2 - 2;
                        }
                        User.activo = 1;
                    }
                } else {
                    actual.setVisibility(View.INVISIBLE);
                    anterior.setVisibility(View.INVISIBLE);
                    actual.setEnabled(true);
                    anterior.setEnabled(true);
                    win.start();
                    if (User.activo == 1) {
                        User.puntaje1 = User.puntaje1 + 100;
                    } else if (User.activo == 2) {
                        User.puntaje2 = User.puntaje2 + 100;
                    }
                    cantidadParejas++;
                }
                colores();
                puntaje1.setText("Puntaje: " + User.puntaje1);
                puntaje2.setText("Puntaje: " + User.puntaje2);
                onClick = 0;
                tiempo.cancel();
                if (cantidadParejas == 8) {
                    termina();
                }
            }
        };
        tiempo.start();
    }


    //Metodo que generar las parejas aleatoriamente
    private void generarParejas() {
        while (asigandos < 16) {
            n = new Random().nextInt(8);
            switch (n + 1) {
                case 1:
                    while (asignado1 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img1);
                        asigandos++;
                        asignado1++;
                    }
                    break;
                case 2:
                    while (asignado2 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img2);
                        asigandos++;
                        asignado2++;
                    }
                    break;
                case 3:
                    while (asignado3 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img3);
                        asigandos++;
                        asignado3++;
                    }
                    break;
                case 4:
                    while (asignado4 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img4);
                        asigandos++;
                        asignado4++;
                    }
                    break;
                case 5:
                    while (asignado5 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img5);
                        asigandos++;
                        asignado5++;
                    }
                    break;
                case 6:
                    while (asignado6 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img6);
                        asigandos++;
                        asignado6++;
                    }
                    break;
                case 7:
                    while (asignado7 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img7);
                        asigandos++;
                        asignado7++;
                    }
                    break;
                case 8:
                    while (asignado8 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img8);
                        asigandos++;
                        asignado8++;
                    }
                    break;
            }
        }
    }

    public void onClick(View view) {
        User.puntaje1 = 0;
        User.puntaje2 = 0;
        finish();
    }
}
