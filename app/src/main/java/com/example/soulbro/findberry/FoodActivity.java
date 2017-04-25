package com.example.soulbro.findberry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {


    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    String flag_des="";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);





        List<Componentes> items = new ArrayList<>(); //Inicializo mi lista de componentes

        //Defino que va a llevar cada molde de lo que cree con el recyclerview
        items.add(new Componentes(R.drawable.delo," De Lolita Restó"));
        items.add(new Componentes(R.drawable.pastora,"Pastora"));
        items.add(new Componentes(R.drawable.arbo,"Arboreo"));

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
                                intent = new Intent(FoodActivity.this,OptionsFoodActivity.class);
                                flag_des="0";
                                intent.putExtra("flag_des",flag_des);
                                startActivity(intent);
                                //Toast.makeText(getApplicationContext(),"De lolita",Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                intent = new Intent(FoodActivity.this,OptionsFoodActivity.class);
                                flag_des="1";
                                intent.putExtra("flag_des",flag_des);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(FoodActivity.this,OptionsFoodActivity.class);
                                flag_des="2";
                                intent.putExtra("flag_des",flag_des);
                                startActivity(intent);
                                break;
                        }



                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                        switch (position)
                        {
                            case 0:
                                Toast.makeText(getApplicationContext(),"Hola Delo",Toast.LENGTH_SHORT).show();
                                break;

                            case 1:
                                Toast.makeText(getApplicationContext(),"Hola Pastora",Toast.LENGTH_SHORT).show();
                                break;


                            case 2:
                                Toast.makeText(getApplicationContext(),"Hola arboreo",Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                })
        );

    }
}
