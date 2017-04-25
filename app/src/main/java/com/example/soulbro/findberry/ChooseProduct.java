package com.example.soulbro.findberry;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ChooseProduct extends AppCompatActivity {

    Intent intent;
    String flag="";
    ImageView imagen;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_product);

        imagen=(ImageView) findViewById(R.id.im);
        confirm = (Button) findViewById(R.id.confirmar);

        Bundle extras = getIntent().getExtras(); //me permite almacenar los extras, recibe la info del intent
        flag = extras.getString("flag_op"); //recibo la info proveniente


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Datos Recibidos", Toast.LENGTH_SHORT).show();
                finish();

            }
        });


        switch (flag)
        {
            case "0":
                imagen.setImageResource(R.drawable.procinal);
                break;
            case "1":
                imagen.setImageResource(R.drawable.royal);
                break;
            case "2":
                imagen.setImageResource(R.drawable.otros);
                break;
        }








    }
}
