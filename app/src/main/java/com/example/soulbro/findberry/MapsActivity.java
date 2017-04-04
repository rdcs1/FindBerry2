package com.example.soulbro.findberry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Intent intent;
    // SharedPreferences prefs;//defino mi objeto
    //SharedPreferences.Editor editor; //requiero un editor


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //  prefs = getSharedPreferences("Mis preferencias ",MODE_PRIVATE);//nombre y modo
        // editor = prefs.edit(); //asi enlazo mis preferencias  y tengo acceso a dicha informacion


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        // Add a marker in Sydney and move the camera
        LatLng udea = new LatLng(6.268021,  -75.567693);
        mMap.addMarker(new MarkerOptions().position(udea).title("Udea").snippet(" Bloque Ingeniería "));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(udea,16));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(udea));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menumaps) {


        getMenuInflater().inflate(R.menu.menumaps,menumaps);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {

            case R.id.central:

                intent = new Intent(MapsActivity.this,MainActivity.class);
                startActivity(intent);


                break;

            case R.id.mLogOut:
               // editor.putInt("login",-1); //valor con el que valido que alguien no se ha logueado
                //editor.commit();
                intent =new Intent(MapsActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }




        return true;
    }
}

