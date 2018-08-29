package com.example.worldskills.emparejapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

public class PuntajesAdapter extends RecyclerView.Adapter<PuntajesAdapter.PuntajesHolderView> {

    @Override
    public PuntajesHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PuntajesHolderView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PuntajesHolderView extends RecyclerView.ViewHolder {
        public PuntajesHolderView(View itemView) {
            super(itemView);
        }
    }
}
