package com.example.mapforhs;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng>arrayList=new ArrayList<>();
    LatLng Philippines = new LatLng(12.8797, 121.7740);
    LatLng MNHS = new LatLng(16.0469, 120.4867);
    LatLng SJNHS = new LatLng(16.0701, 120.4385);
    LatLng TNHS = new LatLng(16.0272, 120.63526);
    LatLng UCU = new LatLng(15.9806, 120.5606);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        arrayList.add(Philippines);
        arrayList.add(MNHS);
        arrayList.add(SJNHS);
        arrayList.add(TNHS);
        arrayList.add(UCU);

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

        for (int i=0; i<arrayList.size(); i++){
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Marker"));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }
    }
}