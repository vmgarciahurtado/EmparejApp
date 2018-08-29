package com.example.worldskills.emparejapp.actividades;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Context;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.content.res.Resources.Theme;

import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.emparejapp.R;
import com.example.worldskills.emparejapp.adapter.PuntajesAdapter;
import com.example.worldskills.emparejapp.entidades.PuntajeVo;
import com.example.worldskills.emparejapp.utilidades.Conexion;
import com.example.worldskills.emparejapp.utilidades.Utilidades;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    Fragment fragment;

    Conexion conn;
    SQLiteDatabase bd;
    ArrayList<PuntajeVo> listaPuntaje;
    PuntajesAdapter adapter;
    RecyclerView recyclerPuntajes;
    PuntajeVo puntajeVo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        conn = new Conexion(getApplicationContext(), "Puntaje", null, 1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        recyclerPuntajes = findViewById(R.id.recyclePuntaje);
        puntajeVo = new PuntajeVo();
        listaPuntaje = new ArrayList<>();

        // Setup spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new MyAdapter(
                toolbar.getContext(),
                new String[]{
                        "FACIL",
                        "MEDIO",
                        "DIFICIL",
                }));

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                consultar(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void consultar(int position) {
        listaPuntaje.clear();
        adapter=null;
        bd = conn.getReadableDatabase();

        Cursor cursor = bd.rawQuery(" SELECT * FROM " + Utilidades.TABLA_JUEGO +
                " WHERE " + Utilidades.CAMPO_NIVEL + "=" + position + "  ORDER BY "+Utilidades.CAMPO_PUNTAJE+" ASC ", null);

        while (cursor.moveToNext()){
            puntajeVo=new PuntajeVo();
            puntajeVo.setJugador(cursor.getString(0));
            puntajeVo.setPuntaje(cursor.getInt(1));
            listaPuntaje.add(puntajeVo);
        }
        adapter = new PuntajesAdapter(listaPuntaje);
        recyclerPuntajes.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }


    private static class MyAdapter extends ArrayAdapter<String> implements ThemedSpinnerAdapter {
        private final ThemedSpinnerAdapter.Helper mDropDownHelper;

        public MyAdapter(Context context, String[] objects) {
            super(context, android.R.layout.simple_list_item_1, objects);
            mDropDownHelper = new ThemedSpinnerAdapter.Helper(context);
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                // Inflate the drop down using the helper's LayoutInflater
                LayoutInflater inflater = mDropDownHelper.getDropDownViewInflater();
                view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            } else {
                view = convertView;
            }

            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getItem(position));

            return view;
        }

        @Override
        public Theme getDropDownViewTheme() {
            return mDropDownHelper.getDropDownViewTheme();
        }

        @Override
        public void setDropDownViewTheme(Theme theme) {
            mDropDownHelper.setDropDownViewTheme(theme);
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main3, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);

            return rootView;
        }
    }
}
