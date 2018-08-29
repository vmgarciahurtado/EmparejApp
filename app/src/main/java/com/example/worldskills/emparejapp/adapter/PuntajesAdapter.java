package com.example.worldskills.emparejapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import com.example.worldskills.emparejapp.R;
import com.example.worldskills.emparejapp.entidades.PuntajeVo;

import java.util.ArrayList;

public class PuntajesAdapter extends RecyclerView.Adapter<PuntajesAdapter.PuntajesHolderView> {

    ArrayList<PuntajeVo>listaPuntajes;

    public PuntajesAdapter(ArrayList<PuntajeVo> listaPuntajes) {
        this.listaPuntajes = listaPuntajes;
    }

    @Override
    public PuntajesHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_lista_puntajes,null,false);
        return new PuntajesHolderView(view);
    }

    @Override
    public void onBindViewHolder(PuntajesHolderView holder, int position) {
        holder.campoNombre.setText("Jugador " + listaPuntajes.get(position).getJugador());
        holder.campoPuntaje.setText("Puntaje " + listaPuntajes.get(position).getPuntaje());
        holder.campoNivel.setText("Nivel " + listaPuntajes.get(position).getNivel());
    }

    @Override
    public int getItemCount() {
        return listaPuntajes.size();
    }

    public class PuntajesHolderView extends RecyclerView.ViewHolder {

        TextView campoNombre,campoPuntaje,campoNivel;
        public PuntajesHolderView(View itemView) {
            super(itemView);
            campoNombre = itemView.findViewById(R.id.campoNombreModelo);
            campoPuntaje = itemView.findViewById(R.id.campoPuntajeModelo);
            campoNivel = itemView.findViewById(R.id.campoNivelModelo);
        }
    }
}
