package com.example.soulbro.findberry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {


    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    Intent intent;
    //preferencias compartidas
    SharedPreferences prefs;//defino mi objeto
    SharedPreferences.Editor editor; //requiero un editor



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //preferencias
        prefs = getSharedPreferences("Mis preferencias ",MODE_PRIVATE);//nombre y modo
        editor = prefs.edit(); //asi enlazo mis preferencias  y tengo acceso a dicha informacion



        //Para el RecyclerView
        List<Componentes> items = new ArrayList<>(); //Inicializo mi lista de componentes

        //Defino que va a llevar cada molde de lo que cree con el recyclerview
        items.add(new Componentes(R.drawable.food," Alimentacion")); //Alimentacion
        items.add(new Componentes(R.drawable.acad," Académico")); //Academico
        items.add(new Componentes(R.drawable.ocio,"Ocio y Otros")); //Ocio y otros

        //Para obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);



        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new ComponentesAdapter(items);
        recycler.setAdapter(adapter);


        //por alla en un menu de desborde, cuando le de logout
        //hago
        //editor.putIn("login",-1); //valor con el que valido que alguien no se ha logueado
        //editor.commit();
        //y que se vaya a Login Activity


    }


    @Override //con este cree el menu
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu); //sigue siendo un recurso entonces lo llamo de esta forma
        return true;
    }


    @Override //con este voy a validar que opcion del menu(que item) que la que presiono
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {

            case R.id.mapita:

                intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);


                break;

            case R.id.mLogOut:
                    editor.putInt("login",-1); //valor con el que valido que alguien no se ha logueado
                    editor.commit();
                    intent =new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();

                    break;



        }


        return true;
    }





}

