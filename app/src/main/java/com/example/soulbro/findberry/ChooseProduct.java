package com.example.soulbro.findberry;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ChooseProduct extends AppCompatActivity {

    Intent intent;
    String flag="";
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_product);

        imagen=(ImageView) findViewById(R.id.im);

        Bundle extras = getIntent().getExtras(); //me permite almacenar los extras, recibe la info del intent
        flag = extras.getString("flag_op"); //recibo la info proveniente


        switch (flag)
        {
            case "0":
                imagen.setImageResource(R.drawable.procinal);
                break;
            case "1":
                imagen.setImageResource(R.drawable.royal);
                break;
        }








    }
}
