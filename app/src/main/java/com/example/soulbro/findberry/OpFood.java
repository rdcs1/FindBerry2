package com.example.soulbro.findberry;

/**
 * Created by SoulBro on 25/04/2017.
 */

public class OpFood {


    private String producto;
    private String precio;
    private String   cantidad;


    //Constructor
    public OpFood(String producto, String precio, String cantidad) {
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public String getPrecio() {
        return precio;
    }

    public String getCantidad() { return cantidad; }
}
