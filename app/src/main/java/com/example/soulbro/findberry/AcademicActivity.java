package com.example.soulbro.findberry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AcademicActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);



        List<Componentes> items = new ArrayList<>(); //Inicializo mi lista de componentes

        //Defino que va a llevar cada molde de lo que cree con el recyclerview
        items.add(new Componentes(R.drawable.cooes,"Cooesdua"));
        items.add(new Componentes(R.drawable.turco," Papeleria Turco"));
        items.add(new Componentes(R.drawable.copi,"Impresiones y Copias"));

        //Para obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);



        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new CompoAdapterdos(items);
        recycler.setAdapter(adapter);

        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recycler ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        //Toast.makeText(getApplicationContext(), "position" + position, Toast.LENGTH_SHORT).show();
                        //Intent intent;
                        switch (position)
                        {
                            case 0:
                                Toast.makeText(getApplicationContext(),"Cooesdua mi perro",Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(getApplicationContext(),"Turco",Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(getApplicationContext(),"otros",Toast.LENGTH_SHORT).show();
                                break;
                        }



                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                        switch (position)
                        {
                            case 0:
                                Toast.makeText(getApplicationContext(),"Hola cooes",Toast.LENGTH_SHORT).show();
                                break;

                            case 1:
                                Toast.makeText(getApplicationContext(),"Hola turco",Toast.LENGTH_SHORT).show();
                                break;


                            case 2:
                                Toast.makeText(getApplicationContext(),"Hola otros",Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                })
        );












    }
}
