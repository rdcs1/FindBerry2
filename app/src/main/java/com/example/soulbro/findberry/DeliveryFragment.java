package com.example.soulbro.findberry;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryFragment extends Fragment implements View.OnClickListener {


    Button b1,b2;
    View view;
    TableLayout tb1,tb2;
    TextView nomuser, product,place;

    public DeliveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_delivery, container, false);
        b1 = (Button) view.findViewById(R.id.vp1);
        b2 = (Button) view.findViewById(R.id.vp2);
        tb2 = (TableLayout) view.findViewById(R.id.tabledespleg);
        tb1 = (TableLayout) view.findViewById(R.id.tablerun);
        nomuser = (TextView) view.findViewById(R.id.nomuser);
        product = (TextView) view.findViewById(R.id.product);
        place = (TextView) view.findViewById(R.id.place);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.vp1:
                tb2.setVisibility(View.VISIBLE);
                nomuser.setText("El varo");
                product.setText("Pan de chocolate");
                place.setText("La miguería");
                break;
            case R.id.vp2:
                nomuser.setText("David");
                product.setText("Sanduche");
                place.setText("Arbóreo");
                tb2.setVisibility(View.VISIBLE);
                break;

        }
    }
}
