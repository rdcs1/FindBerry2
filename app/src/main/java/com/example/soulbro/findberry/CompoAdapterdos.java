package com.example.soulbro.findberry;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SoulBro on 14/04/2017.
 */
public class CompoAdapterdos extends RecyclerView.Adapter<CompoAdapterdos.ComponentesViewHolder> {
    private List<Componentes> items;

    public static class ComponentesViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView text;


        public ComponentesViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.ivOpCardImage);
            text = (TextView) v.findViewById(R.id.tvCard);
        }
    }

    public CompoAdapterdos(List<Componentes> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ComponentesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.option_cards, viewGroup, false);
        return new ComponentesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ComponentesViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.text.setText(items.get(i).getText());

    }
}