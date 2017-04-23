package com.example.soulbro.findberry;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    // Constructor
    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);

        List<Componentes> items = new ArrayList<>(); //Inicializo mi lista de componentes

        //Defino que va a llevar cada molde de lo que cree con el recyclerview
        items.add(new Componentes(R.drawable.food," Alimentacion")); //Alimentacion
        items.add(new Componentes(R.drawable.acad," Académico")); //Academico
        items.add(new Componentes(R.drawable.ocio,"Ocio y Otros")); //Ocio y otros

        //Para obtener el Recycler
        recycler = (RecyclerView) v.findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);


        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new ComponentesAdapter(items);
        recycler.setAdapter(adapter);


        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recycler ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        //Toast.makeText(getApplicationContext(), "position" + position, Toast.LENGTH_SHORT).show();
                        Intent intent;
                        switch (position)
                        {
                            case 0:
                                intent = new Intent(getContext(),FoodActivity.class);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getContext(),AcademicActivity.class);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(getContext(),FunActivity.class);
                                startActivity(intent);
                                break;
                        }



                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                        switch (position)
                        {
                            case 0:
                                Toast.makeText(getContext(),"Hola pendejo alim2",Toast.LENGTH_SHORT).show();
                                break;

                            case 1:
                                Toast.makeText(getContext(),"Hola pendejo acad2",Toast.LENGTH_SHORT).show();
                                break;


                            case 2:
                                Toast.makeText(getContext(),"Hola pendejo ocio2",Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                })
        );






        // Inflate the layout for this fragment
        return v;
    }

}
