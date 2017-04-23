package com.example.soulbro.findberry;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ChooseProduct extends AppCompatActivity {

    Intent intent;
    String proci="";
    String royal="";
    String eventos;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_product);


        Bundle extras = getIntent().getExtras(); //me permite almacenar los extras, recibe la info del intent
        proci = extras.getString("proci"); //recibo la info proveniente
        royal  = extras.getString("royal");
        //eventos = extras.getString("event");
        imagen=(ImageView) findViewById(R.id.im);



        if (proci != "")
        {
            proci = "";
            imagen.setImageResource(R.drawable.procinal);
        }
        else if(royal != "" )
        {

            imagen.setImageResource(R.drawable.royal);
        }

    }
}
