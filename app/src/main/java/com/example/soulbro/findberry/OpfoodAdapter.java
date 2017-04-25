package com.example.soulbro.findberry;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SoulBro on 25/04/2017.
 */

public class OpfoodAdapter extends RecyclerView.Adapter<OpfoodAdapter.OpfoodViewHolder> {
        private List<OpFood> items;

    public OpfoodAdapter(List<OpFood> items) {
        this.items = items;
    }

    public static class OpfoodViewHolder extends RecyclerView.ViewHolder{

            public TextView producto;
            public TextView precio;
            public EditText cantidad;

        public OpfoodViewHolder(View v)
        {
            super(v);
            producto = (TextView) v.findViewById(R.id.producto);
            precio   = (TextView) v.findViewById(R.id.precio);
            cantidad = (EditText) v.findViewById(R.id.cantidad);
        }
    }

    @Override
    public OpfoodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.opfoodcard, viewGroup, false);
        return new OpfoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OpfoodViewHolder viewHolder, int i) {
        viewHolder.producto.setText(items.get(i).getProducto());
        viewHolder.precio.setText(items.get(i).getPrecio());
        viewHolder.cantidad.setText(items.get(i).getCantidad());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
