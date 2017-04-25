package com.example.soulbro.findberry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OptionsFoodActivity extends AppCompatActivity {

    //Instancias globales para crear el Recycler, el layoutManager y el nuevo adaptador
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    String flag="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_food);

        Bundle extras = getIntent().getExtras(); //me permite almacenar los extras, recibe la info del intent
        flag = extras.getString("flag_des"); //recibo la info proveniente


        //Inicializar opFood
        List items = new ArrayList();


        switch (flag)
        {
            //De lolita
            case "0":
                items.add(new OpFood("Pastel de pollo","$ 1800",""));
                items.add(new OpFood("Empanada ","$ 1800",""));
                items.add(new OpFood("Brownie","$ 2000",""));
            break;

            //Pastora
            case "1":
                items.add(new OpFood("Palito de queso","$ 1500",""));
                items.add(new OpFood("Milo frío ","$ 2000",""));
                items.add(new OpFood("Buñuelo","$ 1500",""));
            break;

            //Arboreo
            case "2":
                items.add(new OpFood("S. Primavera","$ 4700",""));
                items.add(new OpFood("Crema tomate ","$ 1800",""));
                items.add(new OpFood("Batido energía","$ 5000",""));

            break;
        }






        //obtener el recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);


        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);


        //Crear un nuevo adaptador
        adapter = new OpfoodAdapter(items);
        recycler.setAdapter(adapter);
    }
}
