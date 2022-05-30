package com.example.lbs;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.util.Log;
import android.location.Address;
import android.location.Geocoder;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.lbs.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng bagasbas = new LatLng(14.1351, 122.9842);
        LatLng provCapitol = new LatLng(14.1123, 122.9548);
        LatLng alawihaoDam = new LatLng(14.1037, 122.9313);
        LatLng stJohn = new LatLng(14.1121, 122.9564);
        if(MainMenu.btnChoice.equals("Bagasbas Beach")) {
            mMap.addMarker(new MarkerOptions().position(bagasbas).title("Bagasbas, Daet"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(bagasbas));
        }
        else if(MainMenu.btnChoice.equals("Provincial Capitol")){
            mMap.addMarker(new MarkerOptions().position(provCapitol).title("Provincial Capitol, Daet"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(provCapitol));
        }
        else if (MainMenu.btnChoice.equals("Alawihao Dam")){
            mMap.addMarker(new MarkerOptions().position(alawihaoDam).title("Alawihao Dam, Daet"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(alawihaoDam));
        }
        else if (MainMenu.btnChoice.equals("St. John Church")){
            mMap.addMarker(new MarkerOptions().position(stJohn).title("St. John Church, Daet"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(stJohn));
        }

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){
            @Override
            public void onMapClick(LatLng point){
               Log.d("DEBUG", "Map clicked [" + point.latitude + " / " + point.longitude + "]");
            }
        });
    }
}