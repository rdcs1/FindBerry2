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

public class FunActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    String flag_op="";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun);


        List<Componentes> items = new ArrayList<>(); //Inicializo mi lista de componentes

        //Defino que va a llevar cada molde de lo que cree con el recyclerview
        items.add(new Componentes(R.drawable.procinal,"Aventura Cine"));
        items.add(new Componentes(R.drawable.royal," Bosques Plaza Cine"));
        items.add(new Componentes(R.drawable.otros,"Eventos"));

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
                                intent = new Intent(FunActivity.this,ChooseProduct.class);
                                flag_op="0";
                                intent.putExtra("flag_op",flag_op);
                                startActivity(intent);
                                //Toast.makeText(getApplicationContext(),proc,Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                intent = new Intent(FunActivity.this,ChooseProduct.class);
                                flag_op="1";
                                intent.putExtra("flag_op",flag_op);
                                startActivity(intent);
                                //Toast.makeText(getApplicationContext(),royal ,Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                intent = new Intent(FunActivity.this,ChooseProduct.class);
                                flag_op="2";
                                intent.putExtra("flag_op",flag_op);
                                startActivity(intent);
                                //Toast.makeText(getApplicationContext(),"Eventos",Toast.LENGTH_SHORT).show();
                                break;
                        }



                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                        switch (position)
                        {
                            case 0:
                                Toast.makeText(getApplicationContext(),"Hola proci",Toast.LENGTH_SHORT).show();
                                break;

                            case 1:
                                Toast.makeText(getApplicationContext(),"Hola royal",Toast.LENGTH_SHORT).show();
                                break;


                            case 2:
                                Toast.makeText(getApplicationContext(),"Hola eventos",Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                })
        );






    }
}
